import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    int frequency;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
        frequency = 0;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
        node.frequency++;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }

    public List<String> getTopNSuggestions(String prefix, int n) {
        List<Pair> wordsWithFreq = new ArrayList<>();
        getWordsWithPrefix(root, prefix, "", wordsWithFreq);
        Collections.sort(wordsWithFreq, (a, b) -> b.frequency - a.frequency);
        List<String> topNWords = new ArrayList<>();
        for (int i = 0; i < Math.min(n, wordsWithFreq.size()); i++) {
            topNWords.add(wordsWithFreq.get(i).word);
        }
        return topNWords;
    }

    private void getWordsWithPrefix(TrieNode node, String prefix, String currentWord, List<Pair> wordsWithFreq) {
        if (prefix.length() > 0) {
            if (!node.children.containsKey(prefix.charAt(0))) {
                return;
            }
            getWordsWithPrefix(node.children.get(prefix.charAt(0)), prefix.substring(1), currentWord + prefix.charAt(0),
                    wordsWithFreq);
        } else {
            if (node.isEndOfWord) {
                wordsWithFreq.add(new Pair(currentWord, node.frequency));
            }
            for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                getWordsWithPrefix(entry.getValue(), "", currentWord + entry.getKey(), wordsWithFreq);
            }
        }
    }

    static class Pair {
        String word;
        int frequency;

        public Pair(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("cherry");
        trie.insert("date");
        trie.insert("elephant");
        trie.insert("fig");
        trie.insert("grape");
        trie.insert("honeydew");
        trie.insert("iguana");
        trie.insert("jackfruit");
        trie.insert("kiwi");
        trie.insert("lemon");
        trie.insert("mango");
        trie.insert("nectarine");
        trie.insert("orange");
        trie.insert("papaya");
        trie.insert("quince");
        trie.insert("raspberry");
        trie.insert("strawberry");
        trie.insert("tangerine");
        trie.insert("ugli fruit");
        trie.insert("vanilla");
        trie.insert("watermelon");
        trie.insert("xigua");
        trie.insert("yam");
        trie.insert("zucchini");
        trie.insert("antelope");
        trie.insert("balloon");
        trie.insert("candle");
        trie.insert("dolphin");
        trie.insert("elevator");
        trie.insert("flamingo");
        trie.insert("guitar");
        trie.insert("horizon");
        trie.insert("illusion");
        trie.insert("jungle");
        trie.insert("kaleidoscope");
        trie.insert("lighthouse");
        trie.insert("mountain");
        trie.insert("novel");
        trie.insert("observatory");
        trie.insert("piano");
        trie.insert("quasar");
        trie.insert("river");
        trie.insert("satellite");
        trie.insert("telescope");
        trie.insert("umbrella");
        trie.insert("violin");
        trie.insert("waterfall");
        trie.insert("xylophone");
        trie.insert("yacht");
        trie.insert("zeppelin");
        trie.insert("aardvark");
        trie.insert("boulevard");
        trie.insert("carousel");
        trie.insert("dynamo");
        trie.insert("escapade");
        trie.insert("fandango");
        trie.insert("galaxy");
        trie.insert("hologram");
        trie.insert("infinity");
        trie.insert("juxtapose");
        trie.insert("kaleidoscope");
        trie.insert("labyrinth");
        trie.insert("mannequin");
        trie.insert("nebula");
        trie.insert("oscillate");
        trie.insert("pandemonium");
        trie.insert("quicksilver");
        trie.insert("renaissance");
        trie.insert("silhouette");
        trie.insert("turbulence");
        trie.insert("unicycle");
        trie.insert("vortex");
        trie.insert("whirlwind");
        trie.insert("xenon");
        trie.insert("yesteryear");
        trie.insert("zenith");
        trie.insert("azimuth");
        trie.insert("barricade");
        trie.insert("cataclysm");
        trie.insert("dichotomy");
        trie.insert("ephemeral");
        trie.insert("flabbergast");
        trie.insert("gravitate");
        trie.insert("haphazard");
        trie.insert("illuminate");
        trie.insert("juggernaut");
        trie.insert("kowtow");
        trie.insert("lexicon");
        trie.insert("mellifluous");
        trie.insert("nomenclature");
        trie.insert("obfuscate");
        trie.insert("periphery");
        trie.insert("quintessence");
        trie.insert("rhapsody");
        trie.insert("synchronize");
        trie.insert("travesty");
        trie.insert("ubiquitous");
        trie.insert("vivacious");
        trie.insert("wanderlust");
        trie.insert("xenophobe");
        trie.insert("yawp");
        trie.insert("zephyr");
        System.out.print("Enter the letters : ");
        Scanner sc = new Scanner(System.in);
        String pre = sc.nextLine();
        System.out.println(trie.getTopNSuggestions(pre, 5));
    }
}
