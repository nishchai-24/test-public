package athenaTesting;

import java.sql.*;
import java.util.Properties;



public class AthenaTesting {

	public void execute() {
		Properties props= new Properties();
		Connection conn = null;
		Statement statement;

		try {
			//setProperties(props);
			//Class.forName(DRIVER_CLASS);
			Class.forName("com.simba.athena.jdbc.Driver");

			//conn=DriverManager.getConnection(ConnectionURL1,props);
			conn=DriverManager.getConnection("jdbc:awsathena://AwsRegion=us-east-1;User=;Password=;S3OutputLocation=s3://movie-list-csv/athena-output/;");
			statement=conn.createStatement();
			//ResultSet rs= statement.executeQuery(QUERY);
			ResultSet rs= statement.executeQuery("select count(*) from sampledb.elb_logs;");
			ResultSetMetaData resultSetMetaData= rs.getMetaData();
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}

			System.out.println("Done");

		}catch(Exception e) {
			e.printStackTrace();

		}finally {
			try{ if (conn!=null)conn.close();}catch (Exception e) {}
		}



	}

	/*
	private void setProperties(Properties properties) {
		System.setProperty("aws.accessKeyId",AWS_ACCESS_KEY);
		System.setProperty("aws.secretKey",AWS_SECRET_KEY);
		System.setProperty("s3outputLocation",s3OutputLocation);
		System.setProperty("AwsCredentialsProviderClass","com.simba.athena.amazonaws.auth.SystemPropertiesCredentailsProvider");



	}
	*/

	  public static void main(String[] args) throws Exception {
		  System.out.println("Hello World");
		  AthenaTesting newAthenaTesting= new AthenaTesting();
		  newAthenaTesting.execute();

	  }


}
