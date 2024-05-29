package com.funfit.dao;

import static com.funfit.resource.DbResource.GetResource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.funfit.bean.Participants;

public class ParticipantsDao {

	public int addParticipants(Participants participants) {
		try {
	Connection con = GetResource().getDbConnection();
	PreparedStatement pstmt = con.prepareStatement("insert into participants(first_name,age,phone_number,batch_id) values(?,?,?,?);");
	pstmt.setString(1, participants.getFirstName());
	pstmt.setInt(2, participants.getAge());
	pstmt.setString(3, participants.getPhoneNumber());
	pstmt.setInt(4, participants.getBatchId());
	return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public List<Participants> viewAllParticipants() {
		List<Participants> listOfParticipats = new ArrayList<>();
		try {
	Connection con = GetResource().getDbConnection();
	PreparedStatement pstmt = con.prepareStatement("select * from participants");
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()) {
		Participants p = new Participants();
		p.setParticipantId(rs.getInt(1));
		p.setFirstName(rs.getString(2));
		p.setAge(rs.getInt(3));
		p.setPhoneNumber(rs.getString(4));
		p.setBatchId(rs.getInt(5));
		listOfParticipats.add(p);
		}
		} catch (Exception e) {
			System.err.println(e);
		}
		return listOfParticipats;
	}
	
	public boolean deleteParticipant(int participantid) {
		try {
			Connection con = GetResource().getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from participants where participant_id = ?");
			pstmt.setInt(1,  participantid);
			return pstmt.execute();
				} catch (Exception e) {
					System.err.println(e);
					return false;
				}
	}
	
	public Participants getParticipant(int participantid) {
		Participants result = new Participants();
		try {
	Connection con = GetResource().getDbConnection();
	PreparedStatement pstmt = con.prepareStatement("select * from participants where participant_id = ?");
	pstmt.setInt(1,  participantid);
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()) {
		result.setParticipantId(rs.getInt(1));
		result.setFirstName(rs.getString(2));
		result.setAge(rs.getInt(3));
		result.setPhoneNumber(rs.getString(4));
		result.setBatchId(rs.getInt(5));
		
		}
		} catch (Exception e) {
			System.err.println(e);
		}
		return result;
	}
	
	public int updateParticipant(Participants participant) {
		try {
			Connection con = GetResource().getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("update participants set first_name = ?, age = ?, phone_number = ?, batch_id = ? where participant_id = ?");
					
			pstmt.setString(1,  participant.getFirstName());
			pstmt.setInt(2, participant.getAge());
			pstmt.setString(3, participant.getPhoneNumber());
			pstmt.setInt(4,  participant.getBatchId());
			pstmt.setInt(5, participant.getParticipantId());
			return pstmt.executeUpdate();
				} catch (Exception e) {
					System.err.println(e);
					return 0;
				}
	}
}