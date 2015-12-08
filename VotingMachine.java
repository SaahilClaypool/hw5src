import java.util.Scanner;

/**
 * Created by Saahil on 12/5/2015.
 */
public class VotingMachine {
	private ElectionData data;
	private Scanner keyboard = new Scanner(System.in);
	public VotingMachine(ElectionData electionData){
		data = electionData;
	}
	public void screen() {
		data.printBallot();
		String[] myVote = new String[3];
		System.out.println("Who is your first choice?");
		String candidate = keyboard.next();
		myVote[0] = candidate;
		System.out.println("Who is your second choice?");
		String candidate2 = keyboard.next();
		myVote[1] = candidate2;
		System.out.println("Who is your third choice?");
		String candidate3 = keyboard.next();
		myVote[2] = candidate3;

		try {
			data.processVotes(myVote[0], myVote[1], myVote[2]);
			System.out.printf("You voted for \n    1. %s \n    2. %s \n    3. %s\n", candidate, candidate2, candidate3);
		}catch (UnknownCandidateException e) {

			System.out.printf("Unknown Canditate: %s\n Please try again\n", e.getCand());
			screen();
		}
		catch (DuplicateVotesException e) {

			System.out.printf("Duplicate Canditate: %s\n Pleast try again", e.getCand());
			screen();


		}

	}

}
