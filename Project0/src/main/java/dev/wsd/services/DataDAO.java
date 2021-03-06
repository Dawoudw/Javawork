package dev.wsd.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.wsd.collections.*;
import dev.wsd.daos.UserDAOmaria;
import dev.wsd.entities.*;
import dev.wsd.utils.DBConnectionUtil;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public class DataDAO {

	public DataDAO() {

	}

	public static IDataService DataServiceOperation = new IDataService() {

		@Override
		public TransTypeCollection<TransactionType> getTransactionTypes() {
			// TODO Auto-generated method stub
			// SELECT ID, TransName, Effect FROM banksysdb.tbl_transactionType;

			TransactionType transType = null;
			TransTypeCollection<TransactionType> transTypeColl = new TransTypeCollection<TransactionType>();
			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement ps = con.prepareStatement("SELECT * FROM banksysdb.tbl_transactionType");) {

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					transType = new TransactionType();
					transType.setId(rs.getInt("ID"));
					transType.setTransName(rs.getString("TransName"));
					transType.setEffect(rs.getBoolean("Effect"));
					transTypeColl.add(transType);
				}

				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

			}
			return transTypeColl;

		}

		@Override
		public AccountTypeCollection<AccountType> getAccountTypes() {
			// TODO Auto-generated method stub
			// SELECT ID, TypeName FROM banksysdb.tbl_accountType;

			AccountType accType = null;
			AccountTypeCollection<AccountType> typeCollection = new AccountTypeCollection<AccountType>();
			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement ps = con
							.prepareStatement("SELECT ID, TypeName FROM banksysdb.tbl_accountType");) {

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					accType = new AccountType();
					accType.setId(rs.getInt("ID"));

					accType.setTypeName(rs.getString("TypeName"));

					typeCollection.add(accType);

				}

				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

			}
			return typeCollection;

		}

		@Override
		public AccountType getAccountTypeById(int id) {
			// TODO Auto-generated method stub
			AccountType accType = null;

			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement ps = con
							.prepareStatement("SELECT ID, TypeName FROM banksysdb.tbl_accountType where ID = ? ");) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					accType = new AccountType();
					accType.setId(rs.getInt("ID"));

					accType.setTypeName(rs.getString("TypeName"));

				}

				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

			}
			return accType;
		}

		@Override
		public TransactionType getTransactionTypeById(int id) {
			// TODO Auto-generated method stub
			TransactionType transType = null;

			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement ps = con
							.prepareStatement("SELECT * FROM banksysdb.tbl_transactionType where ID = ? ");) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					transType = new TransactionType();
					transType.setId(rs.getInt("ID"));
					transType.setTransName(rs.getString("TransName"));
					transType.setEffect(rs.getBoolean("Effect"));

				}

				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

			}
			return transType;
		}
	};

}