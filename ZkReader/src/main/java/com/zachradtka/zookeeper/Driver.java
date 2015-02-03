package com.zachradtka.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class Driver {

	private static ZooKeeper zk;

	private static ZkConnector zkc;

	public static byte[] read(String path) throws KeeperException, InterruptedException {
		return zk.getData(path, true, zk.exists(path, true));
	}

	public static void main(String[] args) throws IOException, InterruptedException,
			KeeperException {

		// Ensure the correct number of args was passed in
		if (args.length != 3) {
			System.err.println("USAGE: ZkConnector <hostname> <port> <path>");
			System.exit(1);
		}

		String hostname = args[0] + ":" + args[1];
		String path = args[2];

		zkc = new ZkConnector();
		zk = zkc.connect(hostname);

		byte[] data = read(path);

		for (byte b : data) {

			System.out.print((char) b);
		}

	}

}
