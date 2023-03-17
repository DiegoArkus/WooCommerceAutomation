<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
# TraPac Api Guide

## Api List

- [TOSCommandsApi](#toscommandsapi)
  - [How to test TOSCommands Api?](#how-to-test-toscommands-api)
  - [YardMovementRequest](#yardmovementrequest)
  - [StopYardMovementRequest](#stopyardmovementrequest)
  - [SendEndTracking](#sendendtracking)
  - [YASDataAccessContainerReport](#yasdataaccesscontainerreport)
- [YASDataAccessApi](#yasdataaccessapi)
  - [How to test YASDataAccess Api?](#how-to-test-yasdataaccess-api)
  - [YASDataAccessContainerReport](#yasdataaccesscontainerreport-1)
- [CHEListenerApi](#chelistenerapi)
  - [How to test CHE Monitoring Api?](#how-to-test-che-monitoring-api)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# TOSCommandsApi

## How to test TOSCommands Api?

Use the environment you need to test (dev/qa).

```
- https://laxyasdev01.trapac.com 
- https://laxyasqa01.trapac.com
```
---

## YardMovementRequest

1. Send **_YardMovement POST request_** with the next endpoint and **_JSON body_** to set the records on the movement report.

### Endpoint:

```
https://laxyasdev01.trapac.com/TOSCommandsApi/v1.0/YardMovement/YardMovementRequest?appName=TrapacPortalInventory@WebApplication/devadmin-
```
### JSON Body:

```
{
    "containerName": "FCIU5001484",
    "area": "B003",
    "lane": "1",
    "bay": "1",
    "priority": "Normal",
    "finalOrientation": "Auto",
    "stopHandling": "Default"
}
```

![YardMovementRequest](https://user-images.githubusercontent.com/68315107/208548265-0849b924-0cdb-4126-82e6-5582b700de4d.png)

If not exist a container transaction to the specific container, a **_400 bad request_** is returned.

![YardMovementBadRequest](https://user-images.githubusercontent.com/68315107/208549709-81c731ea-e099-40bc-b6a7-d7385e6bfadc.png)

---

> 1.1 Send **_SendToWS POST request_** with the next endpoint and **_JSON body_** to set the records on the movement report.

### Endpoint:

```
https://laxyasdev01.trapac.com/TOSCommandsApi/v1.0/YardMovement/YardMovementRequest?appName=TrapacPortalInventory@WebApplication/devadmin-
```
### JSON Body:

```
{
    "containerName": "FANU1431879",
    "area": "WS001"
}
```
![SendToWSRequest](https://user-images.githubusercontent.com/68315107/208551939-7f771211-141f-4709-859c-8568339c5142.png)

---

> 1.2 Send **_SendToBLK POST request_** with the next endpoint and **_JSON body_** to set the records on the movement report.

### Endpoint:

```
https://laxyasdev01.trapac.com/TOSCommandsApi/v1.0/YardMovement/YardMovementRequest?appName=TrapacPortalInventory@WebApplication/devadmin-
```
### JSON Body:

```
{
    "containerName": "FDCU0417329",
    "categoryStack": true
}
```
![SendToBLKRequest](https://user-images.githubusercontent.com/68315107/208552605-84032553-672c-43de-90c0-153daf9639da.png)

---

> 1.3 Send **_SendToGA POST request_** with the next endpoint and **_JSON body_** to set the records on the movement report.

### Endpoint:

```
https://laxyasdev01.trapac.com/TOSCommandsApi/v1.0/YardMovement/YardMovementRequest?appName=TrapacPortalInventory@WebApplication/devadmin-
```
### JSON Body:

```
{
    "containerName": "YMMU4101439",
    "area": "GA001"
}
```
![SendToGARequest](https://user-images.githubusercontent.com/68315107/208553126-479c933b-5011-40e5-a562-9cc75c50b930.png)

---

## StopYardMovementRequest

2. Send **_StopYardMovement POST request_** with the next endpoint and **_JSON body_** to stop a yard movement of specific container.

### Endpoint:

```
https://laxyasdev01.trapac.com/TOSCommandsApi/v1.0/YardMovement/StopYardMovementRequest?appName=TrapacPortalInventory@WebApplication/devadmin-
```
### JSON Body:

```
{
    "containerGuid": "3d795729-4921-0fd7-364d-9594c2ed0b6b",
    "cancelReasonId": 1
}
```

![StopYardMovementRequest](https://user-images.githubusercontent.com/68315107/208775062-c2d96cf9-3d32-47a1-9476-cc81281a66d7.png)

---

## SendEndTracking

3. Send **_SendEndTracking POST request_** with the next endpoint and **_JSON body_** to send final tracking of specific container.

### Endpoint:

```
https://laxyasdev01.trapac.com/TOSCommandsApi/v1.0/YardMovement/SendEndTracking?appName=TrapacPortalInventory@WebApplication/devadmin-
```
### JSON Body:

```
{
    "containerGuid": "c1e03490-9672-4522-aa1f-eb0b83e8d499"
}
```

![SendEndTrackingRequest](https://user-images.githubusercontent.com/68315107/208775790-e8fcc756-a79e-4cba-9b09-0d4be25aa6b0.png)

---

## YASDataAccessContainerReport

4. Send **_YASDataAccessContainerReport GET request_** with the next endpoint to see the records on the container report.

### Endpoint:

```
https://laxyasdev01.trapac.com/YASDataAccessApi/v1/containers
```

![GetContainerReportRequest](https://user-images.githubusercontent.com/68315107/207751072-5693196e-9b16-4d8c-aae5-bbc8c25dd36f.png)

If there is no data on **_YASDataAccessApi_** continue with the next process to send a JMS message to Kalmar, which is the application that processes the container transactions and inserts the data into the database.

5. Send **_JMS request_** through **_JMSMessengerUI_** by completing all of the following fields:

![JMSMessengerUI](https://user-images.githubusercontent.com/68315107/208776311-3c024453-c3a7-49d4-b5d6-e831c5e9161f.png)

---

### Server:

Use the server you need to test (dev/qa).

```
- LAXYASDEV01
- LAXYASQA01
```

![SelectServer](https://user-images.githubusercontent.com/68315107/208783151-50ab3d3c-4672-4093-862c-e88dff03fb4a.png)

---

### Destination:

Use **TOS.IN** destination.

```
TOS.IN
```
![Destination](https://user-images.githubusercontent.com/68315107/208801441-3c360283-c98c-480e-b5e6-704ca25dfb49.png)

---

### Payload:

Use a ContainerReport xml with an Action: **_Created_**

Send a **_Container ID_** and **_Container Name_** you want to use for YardMovementRequest

```
<?xml version="1.0" encoding="utf-8" standalone="yes"?>
<cr:ContainerReport xmlns:cr="trapac.com/TLStoTOS">
	<Timestamp>2021-05-01T14:11:27.8644644Z</Timestamp>
	<ContainerInformation>
		<Container>
			<ContainerID ContainerID="d61f90f0-f66d-42fb-a012-52e50ce101a1"/>
			<ContainerName ContainerName="TRHU7022485"/>
			<Height>2895</Height>
			<Length>12192</Length>
			<Weight>0</Weight>
			<ISOCode>
				<Length>4</Length>
				<Size>5</Size>
				<Type>G0</Type>
			</ISOCode>
			<Orientation>S</Orientation>
		</Container>
		<Position xsi:type="cr:ChassisPosition" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
			<AreaID>LS003</AreaID>
			<Lane>04</Lane>
			<PositionOnChassis>FM</PositionOnChassis>
			<ChassisLength>40</ChassisLength>
			<ChassisType>ContainerChassis</ChassisType>
		</Position>
	</ContainerInformation>
	<Action>Created</Action>
</cr:ContainerReport>
```

![Payload](https://user-images.githubusercontent.com/68315107/208801517-1c543f2c-d9ea-4f3f-bc31-5fd96a37c857.png)

---

### Type:

Use **_Topic_** type.

```
Topic
```
![Type](https://user-images.githubusercontent.com/68315107/207751966-e69f1883-c76c-41c3-84e1-cdbdba2ca382.png)

---

### Requester:

Use default **_Requester_**.

![Requester](https://user-images.githubusercontent.com/68315107/208801747-98fdbe08-c572-460c-900d-eac14052bc52.png)

---

### Message Property:

Use **_MessageName_** with a message property value and add to property list.

```
ContainerReport
```
![SelectMessageProperty](https://user-images.githubusercontent.com/68315107/208801992-e134ce4f-dee2-4712-9649-9106f04e7cbc.png)
![SetMessagePropertyValue](https://user-images.githubusercontent.com/68315107/207912206-6f0b03f5-0bd9-4bc0-9f38-ea3369b7509a.png)
![MessageProperties](https://user-images.githubusercontent.com/68315107/207913235-f704ae3a-0a7f-460b-b460-ba5609e62fe8.png)

---

Once all the data is completed successfully, press the **_Send_** button.

![SendJMSMessage1](https://user-images.githubusercontent.com/68315107/208802559-e2211d13-c019-444e-b7cf-9e458f4e0be5.png)
![SendJMSMessage2](https://user-images.githubusercontent.com/68315107/207910708-83734d00-8536-4481-977b-55736ee6e252.png)
![SendJMSMessage3](https://user-images.githubusercontent.com/68315107/207910739-e9fda57c-95c2-43d4-9771-dc6eb966bde3.png)

---

# YASDataAccessApi

## How to test YASDataAccess Api?

Use the environment you need to test (dev/qa).

```
- https://laxyasdev01.trapac.com
- https://laxyasqa01.trapac.com
```
---

## YASDataAccessContainerReport

1. Send **_YASDataAccessContainerReport GET request_** with the next endpoint to see the records on the container report.

### Endpoint:

```
https://laxyasdev01.trapac.com/YASDataAccessApi/v1/containers
```

![GetContainerReportRequest](https://user-images.githubusercontent.com/68315107/207751072-5693196e-9b16-4d8c-aae5-bbc8c25dd36f.png)

---

If there is no data on **_YASDataAccessApi_** continue with the next process to send a JMS message to Kalmar, which is the application that processes the container transactions and inserts the data into the database.

2. Send **_JMS request_** through **_JMSMessengerUI_** by completing all of the following fields:

![JMSMessengerUI](https://user-images.githubusercontent.com/68315107/208814258-e1b660da-47a4-4d6e-8a98-fdb2e2054b53.png)

---

### Server:

Use the server you need to test (dev/qa).

```
- LAXYASDEV01
- LAXYASQA01
```
![SelectServer](https://user-images.githubusercontent.com/68315107/208814388-f3c0c450-ccaf-4957-82c4-b9e8355af171.png)

---

### Destination:

Use **TOS.IN** destination.

```
TOS.IN
```
![Destination](https://user-images.githubusercontent.com/68315107/208814409-24d0079f-1c35-4a90-968c-b12e9c31e553.png)

---

### Payload:

Use a ContainerReport xml with an Action: **_Created_**

```
<?xml version="1.0" encoding="utf-8" standalone="yes"?>
<cr:ContainerReport xmlns:cr="trapac.com/TLStoTOS">
	<Timestamp>2021-05-01T14:11:27.8644644Z</Timestamp>
	<ContainerInformation>
		<Container>
			<ContainerID ContainerID="d61f90f0-f66d-42fb-a012-52e50ce101a1"/>
			<ContainerName ContainerName="TRHU7022485"/>
			<Height>2895</Height>
			<Length>12192</Length>
			<Weight>0</Weight>
			<ISOCode>
				<Length>4</Length>
				<Size>5</Size>
				<Type>G0</Type>
			</ISOCode>
			<Orientation>S</Orientation>
		</Container>
		<Position xsi:type="cr:ChassisPosition" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
			<AreaID>LS003</AreaID>
			<Lane>04</Lane>
			<PositionOnChassis>FM</PositionOnChassis>
			<ChassisLength>40</ChassisLength>
			<ChassisType>ContainerChassis</ChassisType>
		</Position>
	</ContainerInformation>
	<Action>Created</Action>
</cr:ContainerReport>
```
![Payload](https://user-images.githubusercontent.com/68315107/208814480-e6753fa6-8552-4a17-be6f-19a592d5dc8f.png)

---

### Type:

Use **_Topic_** type.

```
Topic
```
![Type](https://user-images.githubusercontent.com/68315107/208814619-fce74622-115d-4125-992f-a251b23dadc7.png)

---

### Requester:

Use default **_Requester_**.

![Requester](https://user-images.githubusercontent.com/68315107/208815685-4e970996-e1d3-424d-a927-40238f523f92.png)

---

### Message Property:

Use **_MessageName_** with a message property value and add to property list.

```
ContainerReport
```
![SelectMessageProperty](https://user-images.githubusercontent.com/68315107/208815093-41f78bf7-c803-4ca7-bbf8-fbaabf047568.png)
![SetMessagePropertyValue](https://user-images.githubusercontent.com/68315107/207912206-6f0b03f5-0bd9-4bc0-9f38-ea3369b7509a.png)
![MessageProperties](https://user-images.githubusercontent.com/68315107/207913235-f704ae3a-0a7f-460b-b460-ba5609e62fe8.png)

---

Once all the data is completed successfully, press the **_Send_** button.

![SendJMSMessage1](https://user-images.githubusercontent.com/68315107/208815170-f260e3a5-04c9-4f26-b7a7-bfaa326a7f6b.png)
![SendJMSMessage2](https://user-images.githubusercontent.com/68315107/207910708-83734d00-8536-4481-977b-55736ee6e252.png)
![SendJMSMessage3](https://user-images.githubusercontent.com/68315107/207910739-e9fda57c-95c2-43d4-9771-dc6eb966bde3.png)

---

# CHEListenerApi

## How to test CHE Monitoring Api?

Use the environment you need to test (dev/qa).

```
- https://laxyasdev01.trapac.com 
- https://laxyasqa01.trapac.com
```

1. Send **_ProcessCHEStatusReport PUT request_** with the next endpoint and XML body.

---

### Endpoint:

```
https://laxyasqa01.trapac.com/CHEListenerServiceApi/v1.0/TestCHEStatus/ProcessCHEStatusReport
```

---


### XML Body:

```
<cr:CHEStatusReport xmlns:cr="trapac.com/TLStoTOS">
	<Timestamp>2022-06-06T16:41:47.2696522Z</Timestamp>
	<CHEID>ASC003L</CHEID>
	<OperationalStatus>Operational</OperationalStatus>
	<Mode>Auto</Mode>
	<LimpModes/>
	<ContainerID xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				 xsi:type="cr:ContainerIDType"
				 ContainerID="31a79bcf-1f9a-ea72-ca7e-3c6000a03cc4"/>
	<StackOutOfWorkingArea xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
						   xsi:type="cr:SlotPosition">
		<AreaID>WS001</AreaID>
		<Stack xsi:type="cr:FixedStack">
			<Lane>01</Lane>
			<Bay>02</Bay>
		</Stack>
	</StackOutOfWorkingArea>
</cr:CHEStatusReport>

```
---

![ProcessCHEStatusReport](https://user-images.githubusercontent.com/68315107/207181063-9e1f7b65-3c10-45a3-9a79-62cdd60fdcf2.png)

2. Send **_ProcessMoveStatus PUT request_** with the next endpoint and XML body.

---

### Endpoint:

```
https://laxyasqa01.trapac.com/CHEListenerServiceApi/v1.0/TestCHEStatus/ProcessMoveStatus
```

---


### XML Body:

```
<ContainerName>HMMU6196267</ContainerName>
	<CurrentLocation>B016.03.28</CurrentLocation>
	<AssignedEquipment>ASC003L</AssignedEquipment>
	<HandlingEquipment></HandlingEquipment>
	<FirstReport>2021-06-23T12:01:54.872-07:00</FirstReport>
	<LastReport>2021-06-23T12:01:54.872-07:00</LastReport>
	<CrossbowStatus>
		<Sequence>001</Sequence>
		<ActionIdent>Block016Controller-YardMovementAction-130</ActionIdent>
		<LastStatus>Targeting</LastStatus>
		<RequestSourceSystem>LandsideController-TOS@laxcranecrossbow02/stackd-24255</RequestSourceSystem>
		<TargetLocation>B016.99.99</TargetLocation>
		<Tag>8933cff9-ac11-4aa0-b001-578bf5b8831f</Tag>
	</CrossbowStatus>
	<KalmarStatus>
		<Sequence>001</Sequence>
		<MovementID>a020adfc-c3c6-4df9-b377-c6b1de6909de</MovementID>
		<SystemSource>
			Block016Controller-EIS@laxcranecrossbow02/stackd-26501;LandsideController-TOS@laxcranecrossbow02/stackd-24255
		</SystemSource>
		<Priority>Low</Priority>
		<TargetLocation>B016.05.21</TargetLocation>
		<State>ContainerNotOnMap</State>
	</KalmarStatus>
</MoveStatus>

```
---

CHE report must have the same **_ContainerID_** and **_CHEID/AssignedEquipment_** as the related move status.

![ProcessMoveStatus](https://user-images.githubusercontent.com/68315107/207182340-5458d155-43a9-481c-a85e-53138d79ed09.png)

3. Send **_CacheAllContainerTransaction PUT request_** with the next endpoint and JSON body

---

### Endpoint:

```
https://laxyasqa01.trapac.com/CHEListenerServiceApi/v1.0/TestCHEStatus/CacheAllContainerTransaction
```

---


### JSON Body:

```
	{
		"trxUID": 4067272,
		"containerID": "HMMU6196267",
		"containerTRXID": "31a79bcf-1f9a-ea72-ca7e-3c6000a03cc4",
		"currentLocation": "B002.04.17.01",
		"isoCode": "45G1",
		"isCorrectDoorDirection": true,
		"isBadContainer": false,
		"lastMovedDateTime": "2022-07-29T13:19:51.367",
		"createdOn": "2022-07-11T00:54:02.35"
	}

```
---

CHE report must have the same **_ContainerName/containerID_** and **_ContainerID/containerTRXID_** as the related move status.

![MoveStatusTransaction](https://user-images.githubusercontent.com/68315107/207183555-5d91df8f-e41c-4261-b80f-eb50f530275a.png)
