package ex1;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.testng.testcase.AssertJSwingTestngTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Window1Test extends AssertJSwingTestngTestCase {
	 private FrameFixture window;
	 
	/* @BeforeClass 
	 public void before() {
		    FailOnThreadViolationRepaintManager.install();
		  }*/

	@Override
	protected void onSetUp() {
		// TODO Auto-generated method stub
		//ApplicationLauncher.application(Win1.class).start(); ///i used this to test if my app will launch 	 
		
		Window1 frame = GuiActionRunner.execute(() -> new Window1());
		
		window =  new FrameFixture(robot(),frame.f);
	   
	//  window.show(); //does resizeing
		
	}

	@Test
	public void checkLabelString(){
		window.textBox("tf").enterText("Some random text");
	    window.button("b").click();
	    //window.label("lb").requireText("Some random text");
		Assert.assertEquals(window.textBox("tf").target().getText(), window.label("lb").target().getText());
		
	}
	@Test
	public void checkLabelString_fail(){
		window.textBox("tf").enterText("Some random text");
	    window.button("b").click();
	//window.label("lb").requireText("Some random text"); //same as assert 
		Assert.assertEquals( window.label("lb").target().getText(),"NUUUUUUU"); //old style
		
	}
	
	@Test
	public void changeComboBoxItem(){
		String selected1 =  window.comboBox("combobox").selectedItem();
		window.comboBox("combobox").selectItem(2);
		Assert.assertNotEquals(selected1, window.comboBox("combobox").selectedItem());
	}
	
	@Test
	public void changeListItem(){
		String[] selected1 =  window.list("list").selection();
		window.list("list").selectItem(3);
		Assert.assertNotEquals(selected1, window.list("list").selection());
	}
	
	@Test
	public void checkCheckBox(){
		window.checkBox("rb1").check();
		window.checkBox("rb2").check();
		window.checkBox("rb3").check();
		String rb1  =  window.checkBox("rb1").text();
		Assert.assertEquals(window.checkBox("rb1").requireSelected().text(),rb1);
	}
	
	@Test
	public void SelectAssume(){
		window.radioButton("assume").check();
		window.radioButton("male").requireNotSelected();
		window.radioButton("female").requireNotSelected();
	}
	
	@Test
	public void checkFemaleFromMenuItem(){
		window.menuItem("filemenu").click();
		window.menuItem("checkfemale").click();
		window.radioButton("female").requireSelected();
	}
	
	@Test
	public void checkMaleFromMenuItem(){
		window.radioButton("assume").check();
		window.radioButton("assume").requireSelected();
		window.menuItem("filemenu").click();

		window.menuItem("more").click();
	
		window.menuItem("checkmale").click();
	
		window.radioButton("male").requireSelected();
	}
	


}
