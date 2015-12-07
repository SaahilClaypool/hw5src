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

    public void processVote(String first, String second, String third)
            throws DuplicateVotesException, UnknownCandidateException {
        if (!ballot.contains(first)) {
            throw new UnknownCandidateException(first);
        }
        if (!ballot.contains(second)) {
            throw new UnknownCandidateException(second);
        }
        if (!ballot.contains(third)) {
            throw new UnknownCandidateException(third);
        } // TODO refactor into a method. DRY.
        if (first.equals(second) || first.equals(third)) {
            throw new DuplicateVotesException(first);
        }
        if (second.equals(third)) {
            throw new DuplicateVotesException(second);
        }
        // move to data class
        votes.addTally(first, second, third);
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