package javamatlabTests;

import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

import myAdd.JMAdd;;
public class TestMyAdd {
	public static void main(String[] args) throws MWException {
		MWNumericArray a=new MWNumericArray(Double.valueOf(1),MWClassID.DOUBLE);
		MWNumericArray b=new MWNumericArray(Double.valueOf(2),MWClassID.DOUBLE);
		
		JMAdd myadd=new JMAdd();
		Object[] r=myadd.myAdd(1, a,b);
		System.out.println(r[0]);
	}

}
