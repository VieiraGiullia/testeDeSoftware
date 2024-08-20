import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.Main;

public class MainJavaTest {
    @Test
    public void imprimeTest(){
        Main m = new Main();
        String ret = m.imprime();
        assertEquals("teste", ret);
    }
    
    @Test
    public void valorTest(){
        Main a = new Main();
        String ret =  a.valor();
        assertEquals("testeUm", ret);
    }

    @Test
    public void somaTest(){
        Main b = new Main();
        int ret = b.soma();
        assertEquals(4, ret);
    }

    @Test
    public void ehParFalseTest(){
        Main c = new Main();
        //boolean ret = c.ehPar(6);
        assertFalse(c.ehPar(3));
    }
    
    @Test 
    public void ehParTrueTest(){
        Main c = new Main();
        //boolean ret = c.ehPar(6);
        assertTrue(c.ehPar(6));
    }
}
