import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class ElectionData {
    LinkedList<String> ballot = new LinkedList<String>();
    // LinkedList<String> votes = new LinkedList<String>();
    HashMap<String, Integer> firstChoice = new HashMap<>();
    HashMap<String, Integer> secondChoice = new HashMap<>();
    HashMap<String, Integer> thirdChoice = new HashMap<>();


    Scanner keyboard = new Scanner(System.in);

    ElectionData() {
        this.ballot.add("Gompei");
        this.ballot.add("Husky");
    }

    public void printBallot() {
        System.out.println("The candidates are ");
        for (String s : ballot) {
            System.out.println(s);
        }
    }
    public void processVotes(String first, String second, String third) throws DuplicateVotesException, UnknownCandidateException {
        if(!ballot.contains(first)){
            throw new UnknownCandidateException(first);
        }
        if(!ballot.contains(second)){
            throw new UnknownCandidateException(second);
        }
        if(!ballot.contains(second)){
            throw new UnknownCandidateException(second);
        }
        if(first.equals(second) || first.equals(third)){
            throw new DuplicateVotesException(first);
        }
        if(second.equals(third)){
            throw new DuplicateVotesException(second);
        }

        firstChoice.put(first, firstChoice.get(first) +1);
        secondChoice.put(second , secondChoice.get(second) +1);
        thirdChoice.put(third, thirdChoice.get(third) +1);
    }
    public void addCandidate(String cand) throws CandidateExistsException{
        if(!ballot.contains(cand)){
            ballot.add(cand);
            firstChoice.put(cand, 0);
            secondChoice.put(cand , 0);
            thirdChoice.put(cand, 0);
        }
        else
            throw new CandidateExistsException(cand);
    }
    public void screen() {
        this.printBallot();
        System.out.println("Who is your first choice?");
        String candidate = keyboard.next();
        firstChoice.put(candidate,0);
        System.out.println("Who is your second choice?");
        String candidate2 = keyboard.next();
        secondChoice.put(candidate2,0);
        System.out.println("Who is your third choice?");
        String candidate3 = keyboard.next();
        thirdChoice.put(candidate3,0);
        System.out.printf("You voted for \n    1. %s \n    2. %s \n    3. %s\n", candidate, candidate2, candidate3);
    }

    public int countVotes(String forcand) {
        /*int numvotes = 0;
        for (String s : votes) {
            if (s.equals(forcand))
                numvotes = numvotes+1;
        }
        return numvotes;*/
        return 1;
    }
    public String findWinnerMostFirstVotes(){
        final String[] keyMax = {""};
        final int[] maxVal = {0};
        firstChoice.forEach((key,value)->{
            if(value> maxVal[0]){
                maxVal[0] = value;
                keyMax[0] = key;
            }
        });
        return keyMax[0];
    }
    private HashMap<String, Integer> getSumMap(){
        final HashMap<String, Integer> totalPoints = new HashMap<String,Integer>();
        totalPoints.putAll(firstChoice);
        firstChoice.forEach((key, value)->{
            totalPoints.put(key, totalPoints.get(key) + value);
        });
        secondChoice.forEach((key, value)->{
            totalPoints.put(key, totalPoints.get(key) + value);
        });
        secondChoice.forEach((key, value)->{
            totalPoints.put(key, totalPoints.get(key) + value);
        });
        return totalPoints;
    }
    public String findWinnerMostPoints(){
        HashMap<String,Integer> totalPoints = getSumMap();
        final int[] maxVal = {0};
        final String[] maxKey = {""};
        totalPoints.forEach((key,value)-> {
            if(value > maxVal[0]){
                maxVal[0] = value;
                maxKey[0] = key;
            }
        });
        return maxKey[0];
    }
    public static void main(String[] args) {
        ElectionData el = new ElectionData();
        el.screen();

    }
}