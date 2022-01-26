use BlockChain;

create table RecordTrue(
	blockId INT,
    previousBlockHash varchar(100),
    nonce INT,
    trCnt INT,
    BlockHash varchar(100)
);

select * from RecordTrue;
drop table RecordTrue;

create table RecordFalse(
	blockId INT,
    previousBlockHash varchar(100),
    nonce INT,
    trCnt INT,
    BlockHash varchar(100)
);

select * from RecordFalse;
drop table RecordFalse;
