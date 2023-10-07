package application;

import services.ServiceListPlayer;

public class Program {

	public static void main(String[] args) {
		ServiceListPlayer  sp = new ServiceListPlayer("c:\\temp\\jogadores.txt");
		//sp.playerPrint();
		//sp.playerTeamPrint("Palmeiras");	
		//sp.playerTeamGoalsPrint("São Paulo", 3);
		//sp.groupPlayersByTeam();
		System.out.printf("Average of age: %.2f%n",sp.averageAge());
		sp.printOldestPlayer();
		sp.printPlayerNewest();
		sp.printPlayerGoalscorer();
		System.out.println("Goals somatorio: "+sp.somatorioGoals());
		sp.groupPlayersTeam();
		sp.sortPlayersGoals();
	}

}
