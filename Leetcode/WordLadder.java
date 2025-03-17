// 127. Word Ladder

// constraints
// 1. range of length of beginword and endword: 
// 2. range of size of word list
// 3. can begin word be missing from wordlist ? can endword be missing from wordlist? endword missing no sequence existed
// 4. are all words in wordlist guaranteed to have same length with beginword and endword
// 5. can we assume all words contain only lowcase letters?
// 6. is it guaranteed that beginword is different from endword?
// 7. Can words be reused in the transformation sequence
// 8. does the wordlist contain duplicates?

// edge cases
// 1. endword is missing from the wordlist: return 0
// 2. wordlist contains only endword, but endword and beginword differ by more than one letter: return 0
// 

// basic idea
// try all possible path, find the shortest one, use BFS
// start from endword and beginword, try to change one letter at a time, if new word is in the wordlist, add it to the queue,
// record the step, store ('word', step) in the queue
// try to change one letter at a time for words in worlist
// stop when we hit beginword

// coding 

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(endWord);

        Queue<String> queue1 = new LinkedList<>();
        queue1.add(beginWord);
        Queue<String> queue2 = new LinkedList<>();
        queue2.add(endWord);

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        map1.put(beginWord, 1);
        map2.put(endWord, 1);

        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            int res = bfs(queue1, map1, map2, wordSet);
            if(res != -1) return res;

            res = bfs(queue2, map2, map1, wordSet);
            if(res != -1) return res;
        }
        return 0;


    }

    private int bfs(Queue<String> queue, Map<String, Integer> currMap, Map<String, Integer> otherMap, Set<String> wordSet) {
        int size = queue.size();
        for(int i = 0; i < size; i++) {
            String word = queue.poll();
            int steps = currMap.get(word);

            char[] charArray = word.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                char originalChar = charArray[j];

                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == originalChar) continue;
                    charArray[j] = c;
                    String newWord = new String(charArray);
                    if (otherMap.containsKey(newWord)) {
                        return steps + otherMap.get(newWord);
                    }
                    if(wordSet.contains(newWord) && !currMap.containsKey(newWord)){
                        queue.add(newWord);
                        currMap.put(newWord, steps+1);
                    }
                }
                charArray[j] = originalChar;
            }
            
        }
        return -1;
    }

    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }
}

// time complexity: O(M * N), M is the word length, N is the number of words in wordlist


