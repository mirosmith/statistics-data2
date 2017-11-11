package utilityPackageTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import utilityPackage.Utility;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UtilityTest {	
	
	String test1,test2,test3,test4,test5,test6,test7;
	String output1,output2,output3,output4,output5,output6;
	
	@Before
	public void setUp() throws Exception {
		
		test2 = new String();
		test3 = new String("soubor.z");
		test4 = new String("notexist.txt");
		test5 = new String("src/test/resources/link.Ink");
		test6 = new String("src/test/resources/noread.txt");
		test7 = new String("src/test/resources/test8.txt");		
		
		output2 = new String("soubor.tx");
		output3 = new String(".txt");
		output4 = new String("15.txt");
		output5 = new String("soubor.txt");
		output6 = new String("src/test/resources/test8.txt");
	}	

	@Test
	public void inputFileCheckTestA_null() {
		assertFalse(Utility.inputFileCheck(test1));
	}
	@Test
	public void inputFileCheckTestB_empty() {
		assertFalse(Utility.inputFileCheck(test2));
	}
	@Test
	public void inputFileCheckTestC_bad() {
		assertFalse(Utility.inputFileCheck(test3));
	}
	@Test
	public void inputFileCheckTestD_notExists() {
		assertFalse(Utility.inputFileCheck(test4));
	}
	@Test
	public void inputFileCheckTestE_notRegular() {
		assertFalse(Utility.inputFileCheck(test5));
	}
	@Test
	public void inputFileCheckTestF_notReadable() {
		assertFalse(Utility.inputFileCheck(test6));
	}
	@Test
	public void inputFileCheckTestG_correct() {
		assertTrue(Utility.inputFileCheck(test7));
	}
	
	// Output files checking
	
	@Test
	public void outFileCheckTestH_null() {
		assertFalse(Utility.outputFileCheck(output1));
	}
	@Test
	public void outFileCheckTestI_badSuffix() {
		assertFalse(Utility.outputFileCheck(output2));
	}
	@Test
	public void outFileCheckTestJ_badPrefix() {
		assertFalse(Utility.outputFileCheck(output3));
	}
	@Test
	public void outFileCheckTestK_notLetter() {
		assertFalse(Utility.outputFileCheck(output4));
	}
	@Test
	public void outFileCheckTestL_correct() {
		assertTrue(Utility.outputFileCheck(output5));
	}
	@Test
	public void outFileCheckTestM_alreadyExists() {
		assertFalse(Utility.outputFileCheck(output6));
	}

}
