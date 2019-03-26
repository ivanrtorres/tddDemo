package com.neptune.tddDemo.example3;

import com.neptune.tddDemo.template.NullTemplateException;
import com.neptune.tddDemo.template.Template;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TddExercise3Tests {
	
	@Before
	public void setUp(){

	}

	@Test
	public void  canInstantiateATemplate(){
		Template myTemplate=new Template();

		assertNotNull(myTemplate);
	}
	@Test
	public void  canInstantiateATemplateWithAString() throws NullTemplateException {
		String s="new string";
		Template myTemplate=new Template(s);

		assertNotNull(myTemplate);
	}
	@Test
	public void renderMethodReturnAString() throws NullTemplateException {
		String s="";
		Template myTemplate=new Template(s);
		assertNotNull(myTemplate.render());
	}
	@Test
	public void renderMethodReturnMessageGiven() throws NullTemplateException {
		String s="This is the messagge.";
		Template myTemplate=new Template(s);
		assertNotNull(myTemplate.render(s));

		assertEquals(s+"5",myTemplate.render("5"));
	}
	@Test(expected = NullTemplateException.class)
	public void renderThrowsExceptionWithNullTemplate() throws NullTemplateException {

		Template myTemplate=new Template(null);
		String text=myTemplate.render("3");

		assertEquals(text,myTemplate.render("5"));
	}
}
