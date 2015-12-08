import java.util.LinkedList;
import java.util.Scanner;

class ElectionData {
    /**
     * LinkedList of Strings showing list of existing candidates. Used for
     * verification of votes.
     */
    LinkedList<String> ballot = new LinkedList<String>();

    VoteData votes = new HashVote();

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

    /**
     * Add a processVote method that takes three strings (for the first, second,
     * and third choices, respectively) and returns void. This method stores a
     * single voter’s choices in your data structure. (Calling this method
     * corresponds to someone voting in the election.)
     * 
     * @throws DuplicateVotesException
     *             If any two of the three votes are identical.
     * @throws UnknownCandidateException
     *             If any of the three given candidates are not registered on
     *             the ballot.
     */
    public void processVote(String first, String second, String third)
            throws DuplicateVotesException, UnknownCandidateException {
        checkUnknown(first);
        checkUnknown(second);
        checkUnknown(third);

        if (first.equals(second) || first.equals(third)) {
            throw new DuplicateVotesException(first);
        }
        if (second.equals(third)) {
            throw new DuplicateVotesException(second);
        }

        votes.addTally(first, second, third);
    }

    /**
     * Determines Checks to see if the candidate exists in the ballot.
     * 
     * @param candidateName
     *            String representing Candidate.
     * @throws UnknownCandidateException
     *             If the candidate is not in the ballot.
     */
    private void checkUnknown(String candidateName)
            throws UnknownCandidateException {
        if (!ballot.contains(candidateName)) {
            throw new UnknownCandidateException(candidateName);
        }
    }

    /**
     * TODO
     * 
     * @param cand
     * @throws CandidateExistsException
     */
    public void addCandidate(String cand) throws CandidateExistsException {
        // move to data(check and throw) whole method)
        // chekcing if ballot contains still in this?
        if (!ballot.contains(cand)) {
            ballot.add(cand);
            votes.addOption(cand);
        } else
            throw new CandidateExistsException(cand);
    }

    public String findWinnerMostFirstVotes() {
        return votes.getWinnerMostVotes();
    }
    // getSum of individual list, return sum of all three.

    public String findWinnerMostPoints() {
        return votes.getWinnerMostPoints();
    }

    public static void main(String[] args) {
        ElectionData el = new ElectionData();
        VotingMachine ma = new VotingMachine(el);
        ma.screen();

    }
}