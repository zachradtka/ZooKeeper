package com.zachradtka.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class Driver {

	private static ZooKeeper zk;

	private static ZkConnector zkc;

	public static void update(String path, byte[] data) throws KeeperException,
			InterruptedException {
		zk.setData(path, data, zk.exists(path, true).getVersion());
	}

	public static void main(String[] args) throws IOException, InterruptedException,
			KeeperException {

		// Ensure the correct number of args was passed in
		if (args.length != 4) {
			System.err.println("USAGE: ZkConnector <hostname> <port> <znode> <data>");
			System.exit(1);
		}

		String hostname = args[0] + ":" + args[1];
		String path = args[2];
		byte[] data = args[3].getBytes();

		zkc = new ZkConnector();
		zk = zkc.connect(hostname);

		update(path, data);
	}

}
