import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;


import main.DiceGame;

public class DiceGameTest { 
	@Test
	public void test() { assertEquals("0.5731441", new DiceGame().run()); }
}
