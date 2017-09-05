package com.casestudy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ABCDevEngine {
	public Map<Integer, Map> processData(String sourceFolder, String inputfileName) throws EmployeeBusinessException {
		Map<Integer, Map> data = new HashMap<Integer, Map>();
		Map<Integer, String> empData = new TreeMap<Integer, String>();
		BufferedReader br = null;
		EmpVO empVO = null;
		try {
			empVO = new EmpVO();
			br = new BufferedReader(new FileReader(sourceFolder + inputfileName));
			String sCurrentLine;
			String splitStrings[];
			while ((sCurrentLine = br.readLine()) != null) {
				splitStrings = sCurrentLine.split(",");
				empVO.setEmpId(splitStrings[0]);
				empVO.setEmpName(splitStrings[1]);
				empVO.setEmpDesignation(splitStrings[2]);
				String empDetails = empVO.getEmpName() + ", " + empVO.getEmpDesignation();
				empData.put(Integer.parseInt(empVO.getEmpId()), empDetails);
				data.put(new Integer("1"), empData);
			}
			return data;

		} catch (FileNotFoundException fnfe) {
			try {
				throw new EmployeeBusinessException("file/folder does not exist in the mentioned path");
			} catch (EmployeeBusinessException e) {
				e.printStackTrace();
			}
		} catch (IOException ioe) {
			System.out.println("I/O Exception: " + ioe);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;

	}
	
	public static void main(String args[]) throws Exception  {
		ABCDevEngine obj = new ABCDevEngine();
		String sourceFolder = "D:\\Srinivasan\\workspaces\\Practice\\PracticeDemo\\data\\";
		String inputfileName = "emplo1yee.txt";
		Map<Integer,Map> output = null;
		try {
			output = obj.processData(sourceFolder, inputfileName);
			
			System.out.println(output);
	

			
		} catch (EmployeeBusinessException e) {
			e.printStackTrace();
		}		
	}

}

class EmployeeBusinessException extends Exception {
	public EmployeeBusinessException(String message) {
		super(message);
	}

	public EmployeeBusinessException(Throwable throwable) {
		super(throwable);
	}

}

class EmpVO {

	private String empId;
	private String empName;
	private String empDesignation;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpVO other = (EmpVO) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		return true;
	}
}
