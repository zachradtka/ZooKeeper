package com.zachradtka.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class ZkConnector {
	private ZooKeeper zk;

	private CountDownLatch connSignal = new CountDownLatch(1);

	public ZooKeeper connect(String hostname) throws IOException, InterruptedException {
		zk = new ZooKeeper("localhost", 5000, new Watcher() {
			public void process(WatchedEvent event) {
				if (event.getState() == KeeperState.SyncConnected) {
					connSignal.countDown();
				}
			}
		});

		connSignal.await();

		return zk;
	}

	public void close() throws InterruptedException {
		zk.close();
	}
}
