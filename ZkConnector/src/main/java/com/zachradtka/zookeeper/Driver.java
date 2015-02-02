package com.zachradtka.zookeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class Driver {

	private static ZooKeeper zk;

	private static ZkConnector zkc;

	private static List<String> zNodeList = new ArrayList<String>();

	public static void main(String[] args) throws IOException, InterruptedException,
			KeeperException {

		zkc = new ZkConnector();

		zk = zkc.connect("localhost");

		zNodeList = zk.getChildren("/", true);

		for (String znode : zNodeList) {
			System.out.println(znode);
		}
	}

}
