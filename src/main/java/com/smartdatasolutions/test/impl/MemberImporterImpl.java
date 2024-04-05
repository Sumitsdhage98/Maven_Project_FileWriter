package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberImporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MemberImporterImpl implements MemberImporter {

	@Override
	public List< Member > importMembers( File inputFile ) throws Exception {

		/*
		 * Implement the missing logic
		 */

		List<Member> memberList = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader( new FileReader( inputFile ) )) {
			
			String line = null;
			do{
				line = br.readLine( );
				if (line != null) {
	                String column1 = line.substring(0, 12).trim();
	                String column2 = line.substring(12, 37).trim();
	                String column3 = line.substring(37, 62).trim();
	                String column4 = line.substring(62, 92).trim();
	                String column5 = line.substring(92, 112).trim();
	                String column6 = line.substring(112, 116).trim();
	                String column7 = line.substring(116, 121).trim();
	                
	                Member member = new Member();
					member.setId(column1);
					member.setLastName(column2);
					member.setFirstName(column3);
					member.setAddress(column4);
					member.setCity(column5);
					member.setState(column6);
					member.setZip(column7);
					
					memberList.add(member);   

				}
			}while(line != null);
		}
		return memberList;

	}
	
	

}
