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
  <li>A - Admin</li>
  <li>D - Delete</li>
  <li>C - Create</li>
  <li>W - Write</li>
  <li>R - Read</li>
<ul>

###Example 

<table>
  <thead>
    <tr>
      <th>Permission</th>
      <th>Bitmask</th>
      <th>Decimal</th>
    <tr>
  </thead>
  <tbody>
    <tr>
      <td>ADCWR</td>
      <td>11111</td>
      <td>31</td>
    </tr>
    <tr>
      <td>ADCR</td>
      <td>11101</td>
      <td>29</td>
    </tr>
    <tr>
      <td>ACW</td>
      <td>10101</td>
      <td>21</td>
    </tr>
  </tbody>
</table>
