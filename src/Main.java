import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		Particle p1 = new Particle(1, 3.5, 5.7, 2, 2);
		Particle p2 = new Particle(1, 3.5, 3.3, 2, 2);
		Particle p3 = new Particle(1, 3.5, 7, 2, 2);
		Particle p4 = new Particle(1, 1.7, 3.3, 2, 2);
		Particle p5 = new Particle(1, 5, 7, 2, 2);
		Particle p6 = new Particle(1, 5, 3.3, 2, 2);
		Particle p7 = new Particle(1, 5, 5, 2, 2);
		Particle p8 = new Particle(1, 1.7, 5, 2, 2);
		
		Set<Particle> myParticles = new HashSet<>();
		
		myParticles.add(p1);
		myParticles.add(p2);
		myParticles.add(p3);
		myParticles.add(p4);
		myParticles.add(p5);
		myParticles.add(p6);
		myParticles.add(p7);
		myParticles.add(p8);
		
		Filtering f = new Filtering(8, 5);
		
		f.sort(myParticles);
		
		//System.out.println(f.getMap());
		f.search();
		
	}
	


}