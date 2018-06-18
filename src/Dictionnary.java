import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class Dictionnary {


    private Map<String, Integer> translator;

    public Dictionnary() {
        translator = new TreeMap<>();
        translator.put("add", 0);
        translator.put("sub", 1);
        translator.put("div", 2);
        translator.put("mod", 3);
        translator.put("mul", 4);
        translator.put("jmp", 5);
        translator.put("con", 6);
        translator.put("set", 7);
        translator.put("eql", 8);
        translator.put("inf", 9);
    }


    public String translateLine(String line) {

        line = line.trim();

        String word = line.split(" ")[0];

        Integer code = translator.get(word);

        if (code != null) {
            line = line.replaceFirst(word, String.valueOf(code));
        }

        return line;
    }

    public Vector<Integer> formatLine(String line) {

        Vector<Integer> vectors = new Vector<>();

        String[] words = line.split(" ");

        for (String word : words) {
            vectors.add(Integer.parseInt(word));
        }

        return vectors;
    }
}
