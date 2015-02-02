package com.zachradtka.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class Driver {

	private static ZooKeeper zk;

	private static ZkConnector zkc;

	public static void create(String path, byte[] data) throws KeeperException,
			InterruptedException {
		zk.create(path, data, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}

	public static void main(String[] args) throws IOException, InterruptedException,
			KeeperException {
		String path = "/test_zk";
		byte[] data = "sample".getBytes();

		zkc = new ZkConnector();

		zk = zkc.connect("localhost");

		create(path, data);

	}

}
