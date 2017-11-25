package dkm.gdut.com.textdemo.module;

import android.nfc.Tag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

import dkm.gdut.com.textdemo.util.DataUtil;

/**
 * Created by dkmfromCG on 2017/11/15.
 * 代码来源 :App研发录
 * function:在内存不足时,系统会回收一部分闲置资源,由于App被切换到后台,
 * 所以之前存放的全局变量很容易被回收,这时再切换到前台继续使用,在使用某个全局变量的时候,
 * 就会因为全局变量的值为空而崩溃.
 * 最好的解决方法是 :不使用全局变量,把数据作为Intent的参数传递.但是Intent传递的数据类型必须可以序列化,
 * 像JSONObject就不可以传递;而且Intent不能传递过大的数据量,会导致崩溃
 *
 * 另一个解决方法 : 把全局变量序列化到本地,每次修改时都把值序列化到本地
 * (每次修改都要序列化,容易ANR ;序列化生成的文件,会因为内存不够丢失 ;Android提供的数据类型并不是都支持序列化),
 * 这样的话,即使内存中的全局变量被回收,也可以从本地文件在反序列化到内存中
 *
 */

public class GlobalVariables implements Serializable,Cloneable{

    private static final String TAG = "GlobalVariables";

    private static final long serialVersionUID=1L;

    private static GlobalVariables instance;
    private GlobalVariables(){

    }

    public static GlobalVariables getInstance(){
        if (instance==null){
            //从本地文件中反序列化到内存中
            Object object= DataUtil.restoreObject(" ");
            if (object==null){//文件不存在则新建之
                object=new GlobalVariables();
                DataUtil.saveObject(" ",object);
            }
            instance= (GlobalVariables) object;
        }
        return instance;
    }

    private UserBean userBean;
    public UserBean getUser(){
        return userBean;
    }
    public void setUser(UserBean user){
        this.userBean=user;
        DataUtil.saveObject("",this);
    }


    //---------以下方法用来序列化-------------
    public GlobalVariables readResolve()throws
            ObjectStreamException,CloneNotSupportedException{
        instance=(GlobalVariables) this.clone();
        return instance;
    }

    private void readObject(ObjectInputStream ois) throws
            IOException, ClassNotFoundException {
        ois.defaultReadObject();
    }

    public Object Clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void reset(){
        userBean=null;
        DataUtil.saveObject(" ",this);
    }


}
