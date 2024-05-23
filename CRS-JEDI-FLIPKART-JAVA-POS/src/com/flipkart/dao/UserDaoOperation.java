
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

/**
 * This class communicates with the database
 * @author JEDI-03
 *
 */
public class UserDaoOperation implements UserDaoInterface{
    private static volatile UserDaoOperation instance=null;
    private UserDaoOperation()
    {
    }

    public static UserDaoOperation getInstance()
    {
        if(instance==null)
        {
            synchronized(UserDaoOperation.class){
                instance=new UserDaoOperation();
            }
        }
        return instance;
    }



    /**
     * Method to update the password of user
     * @param newPassword
     * @return
     */

    @Override
    public boolean updatePassword(String userId, String newPassword) {
        Connection connection=DBUtils.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.UPDATE_PASSWORD);

            statement.setString(1, newPassword);
            statement.setString(2, userId);

            int row = statement.executeUpdate();

            if(row==1)
                return true;
            else
                return false;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Method to verify credentials of the user from database
     * @param userId
     * @param password
     * @return
     */
    @Override
    public boolean verifyCredentials(String userId, String password)  {
        Connection connection = DBUtils.getConnection();
        try
        {
            PreparedStatement preparedStatement=connection.prepareStatement(SQLQueriesConstants.VERIFY_CREDENTIALS);
            preparedStatement.setString(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                String passwordFetched = resultSet.getString("password");
                if(passwordFetched.equals(password))
                    return true;
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Something went wrong, please try again! "+ ex.getMessage());
        }
        finally
        {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Method to fetch the role of user from database
     * @param userId
     * @return
     */
    @Override
    public String getRole(String userId) {
        Connection connection=DBUtils.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_ROLE);
            statement.setString(1, userId);
            ResultSet rs = statement.executeQuery();

            if(rs.next())
            {
                return rs.getString("role");
            }

        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }


}
