package util;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;


//<T> T ==> HERHANGI BIR DATA TIPI DEMEKTIR
//ObjectMapper().readValue(json, cls) methodu
// birinci parametrede aldığı String formatındaki Json datyı ijkinci parametrede belitilen Java objesine çevirir.
public class ObjectMapperUtils {

    //iki parametre kabul edecek burasi birinci string ,ikincisi de bu class tipi olacak.
    //exception'li kod isteemdigimizi bu clas'i actik
    //Class<T> jernerik yaparasak yani her ne donerse burada o olusur obje desek belki de kisitlasmis olcaz yani yeniden map yapmamiz geekecek.

    public static <T> T   convertJsonToJava(String json,Class<T> cls){  //burada Json'i Java'ya cevircez. //Generik method

        try {
            return new ObjectMapper().readValue(json,cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
ben bu class'da ne yaptim?
bu method ile exception atmadan atmadan string datayi ,diger taraftaki verilen data tipine exception atmadan yapabiliirm

 */
