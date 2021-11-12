package vavi.apps.lisp.jsr223;

import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

import org.junit.jupiter.api.Test;

import vavi.apps.lisp.LispBoolean;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


/**
 * add $DIR/META-INF/services to CLASSPATH 
 */
public class ScriptEngineTest {
    
    @Test
    public void test1() throws Exception {
        ScriptEngineManager sem = new ScriptEngineManager();
        List<ScriptEngineFactory> list = sem.getEngineFactories();

        for (int i = 0; i < list.size(); i++) {
            ScriptEngineFactory f = list.get(i);

            String engineName = f.getEngineName();
            String engineVersion = f.getEngineVersion();
            String langName = f.getLanguageName();
            String langVersion = f.getLanguageVersion();
            System.out.println("\n---- " + i + " ----\n" + engineName + " " +
                    engineVersion + " (" +
                    langName + " " +
                    langVersion + ")");

            String statement = null;
            Object expect = null;

            if (engineName.equals("Mozilla Rhino")) {
                statement = f.getOutputStatement("\"hello, world\"");
                expect = "hello, world";
            } else if (engineName.equals("Vavi Lisp")) {
                statement = f.getOutputStatement("(+ 1 1)");
                expect = new Object[] { LispBoolean.trueValue };
            } else if (engineName.equals("Oracle Nashorn")) {
                statement = f.getOutputStatement("\"hello, world\"");
            } else {
                fail("no suitable script engine");;
            }
            System.out.println("statement: " + statement);

            ScriptEngine e = f.getScriptEngine();
            Object actual = e.eval(statement);
            if (actual instanceof List) {
                assertArrayEquals((Object[]) expect, ((List<?>) actual).toArray());
            } else {
                assertEquals(expect, actual);
            }
        }
    }

    @Test
    public void test2() throws Exception {
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("lisp");

        String statement =
            "(define (append x y)" +
            "  (if (null? x)" +
            "      y" +
            "    (cons (car x) (append (cdr x) y))))" +

            "(define (map f l)" +
            "  (if (null? l)" +
            "      ()" +
            "      (cons (f (car l)) (map f (cdr l)))))" +

            "(define (reverse l)" +
            "  (define (reverse-aux x result)" +
            "    (if (null? x)" +
            "        result" +
            "        (reverse-aux (cdr x) (cons (car x) result))))" +
            "  (reverse-aux l ()))" +
            
            "(define (factorial n)" +
            "  (if (<= n 1)" +
            "      1" +
            "    (* n (factorial (- n 1)))))" +

            "(factorial 10)";
        Object[] actuals = ((List<?>) engine.eval(statement)).toArray();
        for (Object actual : actuals) {
            System.out.println(actual);
        }
        assertEquals(3628800, actuals[4]);
    }
}

/* */