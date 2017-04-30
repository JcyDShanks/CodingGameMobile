package demo.toolbar;

        import android.app.Activity;
        import android.content.Context;
        import android.database.Cursor;
        import android.provider.ContactsContract.CommonDataKinds.Phone;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by JcyDShanks on 2017/4/12.
 * 获取通讯录的信息
 */

public class GetNumber extends Activity {
    public static List <PhoneInfo> lists=new ArrayList<PhoneInfo>();//定义列表
    public static String getNumber(Context context){
        Cursor cursor=context.getContentResolver().query(Phone.CONTENT_URI,null,null,null,null);
        String phoneNumber;     //context.get获取通讯录。query查询Cursor为数据类型
        String phoneName;
        while (cursor.moveToNext()){
            phoneNumber=cursor.getString(cursor.getColumnIndex(Phone.NUMBER ));
            phoneName=cursor.getString(cursor.getColumnIndex(Phone.DISPLAY_NAME));
            PhoneInfo phoneInfo=new PhoneInfo(phoneName,phoneNumber);
            lists.add(phoneInfo);
            System.out.println(phoneName+phoneNumber);
        }
        return null;
    }
}
