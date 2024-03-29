import java.util.*;

public class Main {

	public static void main(String[] args) {
		int Rc;
		if(args.length<1 || (Rc=Integer.parseInt(args[0]))<0)
			throw new RuntimeException("Must provide Rc");
		
		Set<Particle> particles = new HashSet<Particle>();
		
		//Esto es implementando los imputs que nos brinda la catedra
		System.out.println("Reading files...");
		Input.readParticles("Dynamic500.txt", "Static500.txt", particles);

		System.out.println("Starting timer...");
		long valStart = System.currentTimeMillis();

		System.out.println("Creating grid...");
		//public LinearGrid(double L, int M, Set<Particle> particles)
		Grid grid = new LinearGrid(Input.getL(),(int)(Input.getL()/(Rc+2*Input.getRmax())),particles);
		
		System.out.println("Start simulation");
		//public Simulation(Grid grid, double totalTime, double intervals, double Rc)
		
		Simulation s = new Simulation(grid, 1, 1, Rc);
		s.run();

		long valEnd = System.currentTimeMillis();
		System.out.println("Stop timer");
		
		System.out.println("TOTAL TIME IN MILISECONDS: " + (valEnd-valStart));
		
	}
	

	public static void timing(int totalRec, Set<Particle> particles, Double Rc, int L){ 
		
		if(totalRec<=0){
			throw new RuntimeException("M has to be positive");
		}
		
		if(L*1.0/totalRec<Rc){
			
			throw new RuntimeException("No valid M for Cell Index Method. Remember L/M>Rc");
		}
		
		System.out.println("M - Miliseconds");
		
		for(int i=1;i<=totalRec;i++){
			long total = 0;
			for(int j=0; j<100; j++){
				long valStart = System.currentTimeMillis();
				
				Grid grid = new CircularGrid(L,i,particles);
				
				Simulation s = new Simulation(grid, 1, 1, Rc);
				s.run();
				
				total += System.currentTimeMillis()-valStart;
			}
			System.out.println(i + " - " + ((double)total/100));
		}
	}
	
	public static void generateRandomParticles(Set<Particle> particles, int N, double L){
		
		System.out.println("Generating " + N + " random particles, with L: " + L);
		
		//En este caso se nos pide que el R de las particulas sea 0.25
		for(int i=0; i<N; i++){
			particles.add(new Particle(0.25,1,Math.random()*L,Math.random()*L));
		}
	}
	
	/*
	
	
	*/
	
}
