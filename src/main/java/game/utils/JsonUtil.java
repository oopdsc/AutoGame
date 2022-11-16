package game.utils;

import java.util.List;

public class JsonUtil {

    public static Object getFromList(List list){
        return list == null || list.size() == 0 ? 0 : list.get(0);
    }

}
