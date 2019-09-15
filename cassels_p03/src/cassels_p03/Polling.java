package cassels_p03;

import java.util.Scanner;

public class Polling {

	public static void main(String[] args) {
		//initialize variables
		Scanner scnr = new Scanner(System.in);
		String[] topics = {"pineapple on pizza", "cars with loud exhaust", "Forza Horizon 4", "spongebob memes", "University of Central Florida"};
		int[][] responses = new int[5][10];
		int newUser;
		int rating;
		int voters;
		double averageRating;
		int sumRating;
		int maxRating;
		int maxTopicIdx;
		int minRating;
		int minTopicIdx;
		
		//start with no voters
		voters = 0;
		
		//set min and max out of range in opposite directions
		minRating = 11;
		maxRating = 0;
		
		//See if user would like to vote
		System.out.println("Would you like to vote? (1 for yes, 0 for no):");
		newUser = scnr.nextInt();
		
		while(newUser == 1) {
			//loop through topics
			for(int i = 0; i < 5; i++) {
				//prompt user for rating
				System.out.printf("Please rate %s on a scale of 1 to 10 (10 being the best):\n", topics[i]);
				rating = scnr.nextInt();
				
				//add to rating count
				responses[i][rating-1] += 1;
			}
			
			voters++;
			
			//See if user would like to vote
			System.out.println("Would you like to vote? (1 for yes, 0 for no):");
			newUser = scnr.nextInt();
		}
		
		//thank and goodbye
		System.out.println("Thank you! Goodbye.\n");
		
		//print results if votes were cast
		if(voters > 0) {
			//print header
			System.out.printf("%-35s1\t2\t3\t4\t5\t6\t7\t8\t9\t10\tAverage\n", "Topics:");
			
			//initialize min/max topic holders
			minTopicIdx = -1;
			maxTopicIdx = -1;
			
			//loop through topics
			for(int i = 0; i < 5; i++) {
				//initialize rating sum
				sumRating = 0;
				
				//calculate topics total rating
				for(int j = 0; j < 10; j++) {
					sumRating += (responses[i][j] * (j + 1));
				}
				
				//calculate rating average
				averageRating = sumRating/(double)voters;
				
				//find max
				if(sumRating > maxRating) {
					maxRating = sumRating;
					maxTopicIdx = i;
				}
				
				//find min
				if(sumRating < minRating) {
					minRating = sumRating;
					minTopicIdx = i;
				}
				
				//print topic
				System.out.printf("%-35s", topics[i]);
				
				//print topic ratings
				for(int j = 0; j < 10; j++) {
					System.out.printf("%d\t", responses[i][j]);
				}
				
				//print average
				System.out.printf("%.2f", averageRating);
				
				//print break
				System.out.println();
			}
			
			//print max
			System.out.println("\nThe highest rated topic was " + topics[maxTopicIdx] + " with " + maxRating + " points!");

			//print min
			System.out.println("\nThe lowest rated topic was " + topics[minTopicIdx] + " with " + minRating + " points!");
			
			//close scanner
			scnr.close();
		}
	}

}
