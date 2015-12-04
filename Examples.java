import com.sun.org.apache.xpath.internal.SourceTree;
import tester.Tester;

/**
 * Created by saahil claypool on 12/3/2015.
 */
public class Examples {
    // simple test
    public boolean testCandidateExists(Tester t) throws CandidateExistsException {
        ElectionData e = new ElectionData();
        e.addCandidate("tim");
        return t.checkException(new CandidateExistsException("Tim"), e,"addCandidate", "tim");
    }
    // simple test
    public boolean testDuplicateVotes(Tester t) throws CandidateExistsException {
        ElectionData e = new ElectionData();
        e.addCandidate("tim");
        e.addCandidate("tom");
        return t.checkException(new DuplicateVotesException("tim"), e,"processVotes", "tim", "tim","tom");
    }
    public boolean testUnkownCandidate(Tester t) throws CandidateExistsException {
        ElectionData e = new ElectionData();
        e.addCandidate("tim");
        e.addCandidate("tom");
        return t.checkException(new UnknownCandidateException("time"), e,"processVotes", "time", "tim","tom");
    }
    public boolean testOrderOfException(Tester t) throws CandidateExistsException {
        ElectionData e = new ElectionData();
        //would fail both exceptions, should throw unkown first
        return t.checkException(new UnknownCandidateException("tim"), e,"processVotes", "tim", "tim","tom");
    }
    public boolean testMostVotes(Tester t) throws CandidateExistsException, DuplicateVotesException, UnknownCandidateException {
        ElectionData e = new ElectionData();
        e.addCandidate("1");
        e.addCandidate("2");
        e.addCandidate("3");
        e.addCandidate("4");
        e.addCandidate("5");
        e.processVotes("1", "5","3");
        e.processVotes("5","3","4");
        e.processVotes("2","5","4");
        e.processVotes("3","5","4");
        e.processVotes("4","5","1");
        return t.checkExpect("1".equals(e.findWinnerMostFirstVotes()));
    }
    public boolean testMostPoints(Tester t) throws DuplicateVotesException, UnknownCandidateException, CandidateExistsException {
        ElectionData e = new ElectionData();
        e.addCandidate("1");
        e.addCandidate("2");
        e.addCandidate("3");
        e.addCandidate("4");
        e.addCandidate("5");
        e.processVotes("1", "5","3");
        e.processVotes("5","3","4");
        e.processVotes("2","5","4");
        e.processVotes("3","5","4");
        e.processVotes("4","5","1");
        return t.checkExpect("5", e.findWinnerMostPoints());
    }
    public static int test(String s){
        try{
            System.out.println(s.charAt(0));
        }
        catch(Exception e){
            System.out.println("second");
            return 1;
        }
        return 2;

    }
    public static void main(String[] args) {
        Tester.run(new Examples());
        System.out.println(Examples.test(null));
    }
}
