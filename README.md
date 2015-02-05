# ZooKeeper
This project contains sample ZooKeeper code.

## Sub-Projects

<ul>
  <li>ZkConnector</li>
  <li>ZkWriter</li>
  <li>ZkReader</li>
  <li>ZkUpdate</li>
  <li>GetAcl</li>
</ul>

## Permissions

Permissions are stored using a bitmask for 5 types of permissions. The types of permissions are as follows:

<ul>
  <li>Admin (A) - You can set the permissions</li>
  <li>Delete (D) - You can delete a child node</li>
  <li>Create (C) - You can create a child node</li>
  <li>Write (W)- You can set data for a node</li>
  <li>Read (R) - You can get data from a node and list its children</li>
</ul>

###Example 

<table>
  <thead>
    <tr>
      <th>Permission</th>
      <th style="font-family:monospace">A D C W R</th>
      <th>Decimal</th>
    <tr>
  </thead>
  <tbody>
    <tr>
      <td>ADCWR</td>
      <td style="font-family:monospace">1 1 1 1 1</td>
      <td>31</td>
    </tr>
    <tr>
      <td>ADCR</td>
      <td style="font-family:monospace">1 1 1 0 1</td>
      <td>29</td>
    </tr>
    <tr>
      <td>ACW</td>
      <td style="font-family:monospace">1 0 1 0 1</td>
      <td>21</td>
    </tr>
  </tbody>
</table>

### Setting ACLs

ACLs can be set on the command line via the `setAcl` command.

The format for `setAcl` is as follows.
```
[zk: localhost:2181(CONNECTED) 1] setAcl scheme:id:perm
```


