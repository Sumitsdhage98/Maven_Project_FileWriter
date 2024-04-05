package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main extends MemberFileConverter {

	@Override
	protected MemberExporter getMemberExporter( ) {
		// TODO
		return new MemberExporterImpl();
	}

	@Override
	protected MemberImporter getMemberImporter( ) {
		// TODO
		return new MemberImporterImpl();
	}

	@Override
	protected List< Member > getNonDuplicateMembers( List< Member > membersFromFile ) {

		// TODO
		Set<Member> uniqueSet = new HashSet<Member>();
        List<Member> nonDuplicateList = new ArrayList<Member>();
        for (Member member : membersFromFile) {
            if (uniqueSet.add(member)) {
                // If element successfully added to set, then it's unique
                nonDuplicateList.add(member);
            }
        }
        return nonDuplicateList;
	}

	@Override
	protected Map< String, List< Member >> splitMembersByState( List< Member > validMembers ) {
		// TODO
		return validMembers.stream().collect(Collectors.groupingBy(Member::getState));
	}

	public static void main( String[] args ) throws Exception {
		//TODO
		
		File file = new File("Members.txt");
		
		Main main = new Main();
		main.convert(file, System.getProperty("user.dir") + "/output", "outputFile.csv"); 

		
		
		
	}

}
