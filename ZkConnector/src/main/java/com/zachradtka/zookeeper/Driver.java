package com.zachradtka.zookeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class Driver {

	/** A ZooKeeper instance */
	private static ZooKeeper zk;

	/** An instance of ZkConnector */
	private static ZkConnector zkc;

	/** A list of all the znodes */
	private static List<String> znodeList = new ArrayList<String>();

	/**
	 * The main driver
	 * 
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws KeeperException
	 */
	public static void main(String[] args) throws IOException, InterruptedException,
			KeeperException {

		// Ensure the correct number of args was passed in
		if (args.length != 1) {
			System.err.println("USAGE: ZkConnector <hostname>");
			System.exit(1);
		}

		// Initialize the ZooKeeper connector
		zkc = new ZkConnector();

		// Connect to ZooKeeper
		zk = zkc.connect(args[0]);

		// Get all of the znodes and store them in our list
		znodeList = zk.getChildren("/", true);

		// Display the znodes on STDOUT
		for (String znode : znodeList) {
			System.out.println(znode);
		}
	}

}
