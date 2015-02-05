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

Permissions are implemented by using Access Control Lists (ACL) per znode.

### Setting ACLs

ACLs can be set on the command line via the `setAcl` command.

```
[zk: localhost:2181(CONNECTED) 1] setAcl path scheme:id:perm
```

They can also be retrieved by using the `getAcl` command.

```
[zk: localhost:2181(CONNECTED) 1] getAcl path
```

### Built-in ACL Schemes

The following is a list of built ACL schemes:

<ul>
  <li>world - Uses a single id, anyone, that represents anyone</li>
  <li>auth - Doesn't use any id, represents any authenticated user</li>
  <li>digest - Uses a username:password string to generate MD5 hash which is then used as an ACL ID identity</li>
  <li>host - Uses the client host name as an ACL ID identity</li>
  <li>ip - Uses the client host IP as an ACL ID identity</li>
</ul>

### Permissions

Permissions are stored using a bitmask for 5 types of permissions. The types of permissions are as follows:

<ul>
  <li>Admin (A) - You can set the permissions</li>
  <li>Delete (D) - You can delete a child node</li>
  <li>Create (C) - You can create a child node</li>
  <li>Write (W)- You can set data for a node</li>
  <li>Read (R) - You can get data from a node and list its children</li>
</ul>

#### Permission Examples 

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



### `setAcl` Examples

To set a node 'hello' to only have delete, write, and read access, use the folloing command:

```
[zk: localhost:2181(CONNECTED) 1] setAcl /hello world:anyone:dwr
```

To use a digest auth you must first create the auth

```
[zk: localhost:2181(CONNECTED) 1] addauth digest username:userpass
[zk: localhost:2181(CONNECTED) 1] setAcl /temp auth:username:userpass:car
```

