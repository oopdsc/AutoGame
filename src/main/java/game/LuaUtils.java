package game;

import org.apache.commons.io.FileUtils;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;

public class LuaUtils {

    public static LuaValue runLua(String luaFile) throws IOException {
        Resource file = new ClassPathResource(luaFile);

        String luaStr = FileUtils.readFileToString(file.getFile(), Charset.defaultCharset());

        Globals globals = JsePlatform.standardGlobals();
        LuaValue chunk = globals.load(luaStr);
        LuaValue ret = chunk.call();
        return ret;
    }

    public static LuaValue runLua() throws IOException {

//        String luaStr = "print math.random(1,3)";

        String luaStr = "print 'hello,world!'";

        Globals globals = JsePlatform.standardGlobals();
        LuaValue chunk = globals.load(luaStr);
        LuaValue ret = chunk.call();
        return ret;
    }

    public static LuaValue runLuaCommand(String luaStr) throws IOException {

        Globals globals = JsePlatform.standardGlobals();
        LuaValue chunk = globals.load(luaStr);
        LuaValue ret = chunk.call();
        return ret;
    }

    public static LuaValue ret(String luaFile) throws IOException {
        Resource file = new ClassPathResource(luaFile);
//
//        String luaStr = FileUtils.readFileToString(file.getFile(), Charset.defaultCharset());


        Globals globals = JsePlatform.standardGlobals();
        LuaValue transcoderObj = globals.loadfile(file.getFile().toURI().getPath()).call();
        LuaValue func = transcoderObj.get(LuaValue.valueOf("hello3"));
        LuaValue ret = func.call();
        return ret;
    }

    public static void main(String[] args) throws IOException {
//                LuaValue value = LuaUtils.runLua("encryptTime.lua");
        LuaValue value = LuaUtils.runLuaCommand("print 'hello,world!'");
        System.out.println(value);

//        LuaValue value2 = LuaUtils.runLuaCommand("print string.sub(tostring(os.time()),3)");
//        System.out.println(value2);

        LuaValue value3 = LuaUtils.ret("src/test/resources/hello.lua");
        System.out.println(value3);

        System.out.println(new Date().getTime()/1000);
    }
}
