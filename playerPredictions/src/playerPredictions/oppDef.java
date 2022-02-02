package playerPredictions;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class oppDef {
	public static void oppDefRank(String getSt, String value,String value4, String value5, JLabel proLabel, JLabel test1) {
		
		
		double playersPoints = Double.parseDouble(getSt);
		double playersPointsOpp = Double.parseDouble(value4);
		double k=(playersPoints+playersPointsOpp)/2;
		
		/*
		 * DEFENSE RANKING
		 * 1-5:-3
		 * 6-10:-2
		 * 11-15:-1
		 * 16-20:+1
		 * 21-25:+2
		 * 25+:+3
		 * */
		
		if(value=="ATL") {
			k=k+1;
		}
		if(value=="BKN") {
			k=k-2;
		}
		if(value=="BOS") {
			k=k-1;
		}
		if(value=="CHA") {
			k=k-1;
		}
		if(value=="CHI") {
			k=k-3;	
		}
		if(value=="CLE") {
			k=k-3;	
		}
		if(value=="DAL") {
			k=k-2;	
		}
		if(value=="DEN") {
			k=k-1;
		}
		if(value=="DET") {
			k=k+3;
		}
		if(value=="GSW") {
			k=k-3;	
		}
		if(value=="HOU") {
			k=k+3;	
		}
		if(value=="IND") {
			k=k+2;
		}
		if(value=="LAC") {
			k=k-1;
		}
		if(value=="LAL") {
			k=k+1;
		}
		if(value=="MEM") {
			k=k-3;
		}
		if(value=="MIA") {
			k=k-3;
		}
		if(value=="MIL") {
			k=k-3;
		}
		if(value=="MIN") {
			k=k+1;	
		}
		if(value=="NOH") {
			k=k+3;
		}
		if(value=="NYK") {
			k=k+1;	
		}
		if(value=="OKC") {
			k=k+3;
		}
		if(value=="ORL") {
			k=k+3;
		}
		if(value=="PHI") {
			k=k-3;
		}
		if(value=="PHO") {
			k=k-3;
		}
		if(value=="POR") {
			k=k+2;
		}
		if(value=="SAC") {
			k=k+3;
		}
		if(value=="TOR") {
			k=k+1;
		}
		if(value=="UTH") {
			k=k-2;
		}
		if(value=="WAS") {
			k=k+2;
		}
		/*
		 * PLAYER MISSING THAT GAME
		 * 30%:+3
		 * 20%:+2
		 */
		if(value5=="Trey Young") {
			k=k+3;
		}
		if(value5=="John Collins") {
			k=k+2;
		}
		if(value5=="Kevin Durant") {
			k=k+3;
		}
		if(value5=="Kyrie Irving") {
			k=k+2;
		}
		if(value5=="James harden") {
			k=k+2;
		}
		if(value5=="Jayson Tatum") {
			k=k+3;
		}
		if(value5=="Jaylen Brown") {
			k=k+2;
		}
		if(value5=="Miles Bridges") {
			k=k+3;
		}
		if(value5=="Terry Rozeir") {
			k=k+3;
		}
		if(value5=="LaMelo Ball") {
			k=k+2;
		}
		if(value5=="DeMar DeRozan") {
			k=k+3;
		}
		if(value5=="Zach LaVine") {
			k=k+3;
		}
		if(value5=="Jarrett Allen") {
			k=k+2;
		}
		if(value5=="Darius Garland") {
			k=k+2;
		}
		if(value5=="Evan Mobley") {
			k=k+2;
		}
		if(value5=="Luka Doncic") {
			k=k+3;
		}
		if(value5=="Kristaps Porzingis") {
			k=k+3;
		}
		if(value5=="Nikola Jokic") {
			k=k+3;
		}
		if(value5=="Will Barton") {
			k=k+2;
		}
		if(value5=="Cade Cunningham") {
			k=k+3;
		}
		if(value5=="Saddiq Bey") {
			k=k+2;
		}
		if(value5=="Stephen Curry") {
			k=k+3;
		}
		if(value5=="Andrew Wiggins") {
			k=k+3;
		}
		if(value5=="Christian Wood") {
			k=k+3;
		}
		if(value5=="Jalen Green") {
			k=k+2;
		}
		if(value5=="Domantas Sabonis") {
			k=k+3;
		}
		if(value5=="Caris LeVert") {
			k=k+3;
		}
		if(value5=="Paul George") {
			k=k+3;
		}
		if(value5=="Reggie Jackson") {
			k=k+2;
		}
		if(value5=="LeBron James") {
			k=k+3;
		}
		if(value5=="Anthony Davis") {
			k=k+3;
		}
		if(value5=="Ja Morant") {
			k=k+3;
		}
		if(value5=="Desmond Bane") {
			k=k+2;
		}
		if(value5=="Jimmy Butler") {
			k=k+3;
		}
		if(value5=="Tyler Herro") {
			k=k+2;
		}
		if(value5=="Giannis Antetokounmpo") {
			k=k+3;
		}
		if(value5=="Kris Middleton") {
			k=k+3;
		}
		if(value5=="Karl-Anthony Towns") {
			k=k+3;
		}
		if(value5=="Anthony Edwards") {
			k=k+2;
		}
		if(value5=="Brandon Ingram") {
			k=k+3;
		}
		if(value5=="Jonas Valanciunas") {
			k=k+2;
		}
		if(value5=="Julius Randle") {
			k=k+3;
		}
		if(value5=="Shai Gilgeaous-Alexander") {
			k=k+3;
		}
		if(value5=="Luguentz Dort") {
			k=k+2;
		}
		if(value5=="Cole Anthony") {
			k=k+2;
		}
		if(value5=="Franz Wagner") {
			k=k+2;
		}
		if(value5=="Joel Embiid") {
			k=k+3;
		}
		if(value5=="Tobias Harris") {
			k=k+2;
		}
		if(value5=="Devin Booker") {
			k=k+3;
		}
		if(value5=="Chris Paul") {
			k=k+2;
		}
		if(value5=="Damian Lillard") {
			k=k+3;
		}
		if(value5=="CJ McCollum") {
			k=k+2;
		}
		if(value5=="De'Aaron Fox") {
			k=k+3;
		}
		if(value5=="Fred VanVleet") {
			k=k+3;
		}
		if(value5=="Pascal Siakam") {
			k=k+2;
		}
		if(value5=="Donovan Mitchell") {
			k=k+3;
		}
		if(value5=="Rudy Gobert") {
			k=k+2;
		}
		if(value5=="Bradley Beal") {
			k=k+3;
		}
		if(value5=="Kyle Kuzma") {
			k=k+2;
		}
		
		
		
		
		String s=String.valueOf(k);
		proLabel.setText(s);
	}

}
