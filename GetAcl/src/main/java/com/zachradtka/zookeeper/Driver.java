package com.zachradtka.zookeeper;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;

public class Driver {

	private static ZooKeeper zk;

	private static ZkConnector zkc;

	public static List<ACL> getAcl(String path) throws KeeperException, InterruptedException {
		return zk.getACL(path, zk.exists(path, true));
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

		List<ACL> aclList = getAcl(path);

		for (ACL acl : aclList) {
			System.out.println(acl.toString());
		}
	}

}
