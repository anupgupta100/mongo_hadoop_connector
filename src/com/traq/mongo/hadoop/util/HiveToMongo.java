//package com.traq.mongo.hadoop.util;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.conf.Configured;
//import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.LongWritable;
//import org.apache.hadoop.io.Text;
//import org.apache.hadoop.mapreduce.Job;
//import org.apache.hadoop.mapreduce.Mapper;
//import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
//import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
//import org.apache.hadoop.util.Tool;
//import org.apache.hadoop.util.ToolRunner;
//
//import com.mongodb.hadoop.MongoOutputFormat;
//import com.mongodb.hadoop.io.BSONWritable;
//import com.mongodb.hadoop.util.MongoConfigUtil;
//
///**
// * Refer :
// * https://github.com/yc-huang/Hive-mongo
// */
//public class HiveToMongo extends Configured implements Tool {
//
//    private static class HiveToMongoMapper extends
//            Mapper<LongWritable, Text, IntWritable, BSONWritable> {
//
//        //See: https://issues.apache.org/jira/browse/HIVE-634
//        private static final String HIVE_EXPORT_DELIMETER = '\001' + "";
//        private IntWritable k = new IntWritable();
//        private BSONWritable v = null;
//
//        @Override
//        public void map(LongWritable key, Text value, Context context)
//                throws IOException, InterruptedException {
//
//            String [] split = value.toString().split(HIVE_EXPORT_DELIMETER);
//            k.set(Integer.parseInt(split[0]));
//            v = new BSONWritable();
//            v.put("firstname", split[1]);
//            v.put("lastname", split[2]);
//            context.write(k, v);
//
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        try {
//            Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver");
//        }
//        catch (ClassNotFoundException e) {
//            System.out.println("Unable to load Hive Driver");
//            System.exit(1);
//        }
//
//        try {
//            Connection con = DriverManager.getConnection(
//                    "jdbc:hive://localhost:10000/default");
//            Statement stmt = con.createStatement();
//            String sql = "INSERT OVERWRITE DIRECTORY " +
//                    "'hdfs://localhost:8020/user/hive/tmp' select * from users";
//            stmt.executeQuery(sql);
//
//        }
//        catch (SQLException e) {
//            System.exit(1);
//        }
//
//        int res = ToolRunner.run(new Configuration(), new HiveToMongo(), args);
//        System.exit(res);
//    }
//
//    @Override
//    public int run(String[] args) throws Exception {
//
//        Configuration conf = getConf();
//        Path inputPath = new Path("/user/hive/tmp");
//        String mongoDbPath = "mongodb://127.0.0.1:6900/mongo_users.mycoll";
//        MongoConfigUtil.setOutputURI(conf, mongoDbPath);
//
//        /*
//        Add dependencies to distributed cache via
//        DistributedCache.addFileToClassPath(...) :
//        - mongo-hadoop-core-x.x.x.jar
//        - mongo-java-driver-x.x.x.jar
//        - hive-jdbc-x.x.x.jar
//        HadoopUtils is an own utility class
//        */
//        HadoopUtils.addDependenciesToDistributedCache("/libs/mongodb", conf);
//        HadoopUtils.addDependenciesToDistributedCache("/libs/hive", conf);
//
//        Job job = new Job(conf, "HiveToMongo");
//        FileInputFormat.setInputPaths(job, inputPath);
//        job.setJarByClass(HiveToMongo.class);
//        job.setMapperClass(HiveToMongoMapper.class);
//        job.setInputFormatClass(TextInputFormat.class);
//        job.setOutputFormatClass(MongoOutputFormat.class);
//        job.setOutputKeyClass(Text.class);
//        job.setOutputValueClass(Text.class);
//        job.setNumReduceTasks(0);
//
//        job.submit();
//        System.out.println("Job submitted.");
//        return 0;
//    }
//
//    }
