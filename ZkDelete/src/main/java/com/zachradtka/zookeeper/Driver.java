package com.zachradtka.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class Driver {

	private static ZooKeeper zk;

	private static ZkConnector zkc;

	public static void delete(String path) throws KeeperException, InterruptedException {
		zk.delete(path, zk.exists(path, true).getVersion());
	}

	public static void main(String[] args) throws IOException, InterruptedException,
			KeeperException {

		// Ensure the correct number of args was passed in
		if (args.length != 3) {
			System.err.println("USAGE: ZkConnector <hostname> <port> <znode>");
			System.exit(1);
		}

		String hostname = args[0] + ":" + args[1];
		String path = args[2];

		zkc = new ZkConnector();
		zk = zkc.connect(hostname);

		delete(path);
	}

}
