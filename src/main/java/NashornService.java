import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.*;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

public class NashornService {

    public void invokeScriptContent() {
        String str = "This is a java global variable accessible in js file";
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        try {
            NashornService nashornService = new NashornService();
            engine.put("javaGlobalVar", str);
            System.out.println("*****************************Nashorn Demo Starts*****************************");
            engine = NashornService.evaluateScriptFile(engine);
            System.out.println("*****************************Nashorn Demo Ends*****************************");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ScriptEngine evaluateScriptFile(ScriptEngine scriptEngine) throws Exception {
        scriptEngine.eval(new FileReader("javascript-program-files/script.js"));
        return scriptEngine;
    }
}


