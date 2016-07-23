package nashorngrailsapp

import grails.transaction.Transactional
import jdk.nashorn.api.scripting.ScriptObjectMirror

import javax.script.Invocable
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

@Transactional
class NashornScriptInvocationService {

    public Map invokeScriptContent(String methodName, Object... args) {
        ScriptObjectMirror result
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        try {
            engine = evaluateScriptFile(engine);
            Invocable invocable = (Invocable) engine;
            result = (ScriptObjectMirror) invocable.invokeFunction(methodName,args);
        } catch (Exception e) {
            e.printStackTrace()
        }
        (Map) result
    }

    public static ScriptEngine evaluateScriptFile(ScriptEngine scriptEngine) throws Exception {
        scriptEngine.eval(new FileReader("javascript-program-files/script.js"));
        return scriptEngine;
    }

    public void invokeScriptTopLevelFunctions(ScriptEngine scriptEngine) throws Exception {
        Invocable invocable = (Invocable) scriptEngine;
        List<User> userList
        ScriptObjectMirror result = (ScriptObjectMirror) invocable.invokeFunction("getUsers");
        System.out.println("Result Class :: " + result.getClass());
        Map map = (Map) result;
        Iterator entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            System.out.println("Key = " + entry.getKey() + " , Value = " + entry.getValue() + " , Value's Class = " + entry.getValue().getClass());
            userList = entry.getValue()
        }
    }
}
