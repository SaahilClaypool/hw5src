import tester.Tester;

/**
 * Created by saahil claypool on 12/3/2015.
 */
public class Examples {
    /*
     * Tests that addCandidate() throws candidateExistsException
     */
    public boolean testCandidateExists(Tester t)
            throws CandidateExistsException {
        ElectionData e = new ElectionData();
        e.addCandidate("tim");
        return t.checkException(new CandidateExistsException("Tim"), e,
                "addCandidate", "tim");
    }

    /*
     * Tests that processVote() throws duplicate votes exception with repeated
     * name in votes.
     */
    public boolean testDuplicateVotes(Tester t)
            throws CandidateExistsException {
        ElectionData e = new ElectionData();
        e.addCandidate("valueIrrelevant");
        e.addCandidate("tim");
        e.addCandidate("tom");
        return t.checkException(new DuplicateVotesException("tim"), e,
                "processVote", "tim", "tim", "tom");
    }

    /*
     * 
     */
    public boolean testUnkownCandidate(Tester t)
            throws CandidateExistsException {
        ElectionData e = new ElectionData();
        e.addCandidate("tim");
        e.addCandidate("tom");
        return t.checkException(new UnknownCandidateException("time"), e,
                "processVote", "time", "tim", "tom");
    }

    public boolean testOrderOfException(Tester t)
            throws CandidateExistsException {
        ElectionData e = new ElectionData();
        // would fail both exceptions, should throw unkown first
        return t.checkException(new UnknownCandidateException("tim"), e,
                "processVote", "tim", "tim", "tom");
    }

    public boolean testMostVotes(Tester t) throws CandidateExistsException,
            DuplicateVotesException, UnknownCandidateException {
        ElectionData e = new ElectionData();
        e.addCandidate("1");
        e.addCandidate("2");
        e.addCandidate("3");
        e.addCandidate("4");
        e.addCandidate("5");
        e.processVote("1", "5", "3");
        e.processVote("5", "3", "4");
        e.processVote("2", "5", "4");
        e.processVote("3", "5", "4");
        e.processVote("4", "5", "1");
        return t.checkExpect("1".equals(e.findWinnerMostFirstVotes()));
    }

    public boolean testMostPoints(Tester t) throws DuplicateVotesException,
            UnknownCandidateException, CandidateExistsException {
        ElectionData e = new ElectionData();
        e.addCandidate("1");
        e.addCandidate("2");
        e.addCandidate("3");
        e.addCandidate("4");
        e.addCandidate("5");
        e.processVote("1", "5", "3");
        e.processVote("5", "3", "4");
        e.processVote("2", "5", "4");
        e.processVote("3", "5", "4");
        e.processVote("4", "5", "1");
        return t.checkExpect("5", e.findWinnerMostPoints());
    }

    public static void main(String[] args) {
        Tester.run(new Examples());

    }
}
