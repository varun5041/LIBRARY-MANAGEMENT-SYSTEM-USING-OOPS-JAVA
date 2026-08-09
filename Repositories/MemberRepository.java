package Repositories;

import Database.databaseConnection;
import Models.Member;
import Models.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    public void addMember(Member member) throws SQLException {

        String sql = "INSERT INTO members (id, name) VALUES (?, ?)";

        Connection connection = databaseConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, member.getMemberId());
        statement.setString(2, member.getMembername());

        statement.executeUpdate();
    }


    // GET ALL MEMBERS
    public List<Member> getAllMembers() throws SQLException {

        String sql = "SELECT * FROM members";

        Connection connection = databaseConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();

        List<Member> members = new ArrayList<>();

        while (rs.next()) {

            Member member = new Member(
                    rs.getInt("id"),
                    rs.getString("name")
            );

            members.add(member);
        }

        return members;
    }


    // GET MEMBER BY ID
    public Member getMemberById(int id) throws SQLException {

        String sql = "SELECT * FROM members WHERE id = ?";

        Connection connection = databaseConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();

        if (rs.next()) {

            return new Member(
                    rs.getInt("id"),
                    rs.getString("name")
            );
        }

        return null;
    }


    // DELETE MEMBER
    public void deleteMember(int id) throws SQLException {

        String sql = "DELETE FROM members WHERE id = ?";

        Connection connection = databaseConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        statement.executeUpdate();
    }
}
