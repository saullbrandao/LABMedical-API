--ADDRESSES
INSERT ALL
  INTO ADDRESSES (ID, ADDRESS_NUMBER, CEP, CITY, DISTRICT, STATE, STREET)
  VALUES('b0f88997-bab5-4ec8-94cf-5fec574b7f94', 122, '89035-010', 'Blumenau', 'Vila Nova', 'Santa Catarina', 'Rua Campos Sales')
  INTO ADDRESSES (ID, ADDRESS_NUMBER, CEP, CITY, DISTRICT, STATE, STREET)
  VALUES('26640833-cf7a-4424-a7de-d67c406fdf69', 451, '88706-522', 'Tubarão', 'Progresso', 'Santa Catarina', 'Rua Etelvina da Silva')
  INTO ADDRESSES (ID, ADDRESS_NUMBER, CEP, CITY, DISTRICT, STATE, STREET)
  VALUES('16844dea-50fd-445e-864a-ec339478fa6c', 1347, '89026-201', 'Blumenau', 'Progresso', 'Santa Catarina', 'Rua Progresso')
  INTO ADDRESSES (ID, ADDRESS_NUMBER, CEP, CITY, DISTRICT, STATE, STREET)
  VALUES('41164462-9219-4627-bb7a-1c46a90b2551', 845, '88805-791', 'Criciúma', 'Imperatriz', 'Santa Catarina', 'Rua Manoel José da Rosa')
SELECT * FROM dual
WHERE NOT EXISTS (SELECT 1 FROM ADDRESSES);

--DOCTORS
INSERT ALL
  INTO DOCTORS (ID, BIRTH_DATE, CPF, EMAIL, GENDER, MARITAL_STATUS, NAME, NATIONALITY, PHONE, RG, CRM, PASSWORD, SPECIALIZATION)
  VALUES('3c95eb9c-76db-4b59-8d60-1c11a93c92df', TO_DATE('1968-01-12','YYYY-MM-DD'), '60265245257', 'edsonkevinmoura@plani.com.br', 'MALE',
   'MARRIED', 'Edson Kevin Joaquim Moura', 'Brazil', '68999250664', '424924948', '132211234', 'wtraHr0usS', 'GENERAL_PRACTITIONER')
  INTO DOCTORS (ID, BIRTH_DATE, CPF, EMAIL, GENDER, MARITAL_STATUS, NAME, NATIONALITY, PHONE, RG, CRM, PASSWORD, SPECIALIZATION)
  VALUES('1cd4c588-c9b5-4c88-af4f-b89e4544b0cc', TO_DATE('1969-04-14','YYYY-MM-DD'), '15922717154', 'pedro-assis83@antunez.com.br', 'MALE',
  'DIVORCED', 'Pedro Renato Assis', 'Brazil', '68999250664', '419408071', '342343425', '0UnCuiceaX', 'PEDIATRICS')
SELECT * FROM dual
WHERE NOT EXISTS (SELECT 1 FROM DOCTORS);

--PATIENTS
INSERT ALL
  INTO PATIENTS (ID, BIRTH_DATE, CPF, EMAIL, GENDER, MARITAL_STATUS, NAME, NATIONALITY, PHONE, RG, EMERGENCY_CONTACT, ADDRESS_ID)
  VALUES('5bc7f4b0-16f0-445e-b1f7-92684752e5d5', TO_DATE('1991-03-08','YYYY-MM-DD'), '91590680944', 'francisco_rodrigues@lavabit.com', 'MALE',
   'SINGLE', 'Francisco Giovanni Rodrigues', 'Brazil', '47984507736', '415570451', '68999234589', '16844dea-50fd-445e-864a-ec339478fa6c')
  INTO PATIENTS (ID, BIRTH_DATE, CPF, EMAIL, GENDER, MARITAL_STATUS, NAME, NATIONALITY, PHONE, RG, EMERGENCY_CONTACT, ADDRESS_ID)
  VALUES('901cab5a-3a9e-4f26-8d55-6166eb60b730', TO_DATE('1953-02-01','YYYY-MM-DD'), '34131566915', 'pietra_sonia_ribeiro@sheilabenavente.com.br', 'FEMALE',
  'WIDOWED', 'Pietra Sônia Laís Ribeiro', 'Brazil', '48981828908', '344736349', '4836368824', '41164462-9219-4627-bb7a-1c46a90b2551')
SELECT * FROM dual
WHERE NOT EXISTS (SELECT 1 FROM PATIENTS);

--APPOINTMENTS
INSERT ALL
  INTO APPOINTMENTS (ID, DESCRIPTION, PRECAUTIONS, PRESCRIPTION, REASON, "TIME", DOCTOR_ID, PATIENT_ID)
  VALUES('cbe9a6a2-5575-44da-ab43-17b1c846dcd4', 'At vero eos et accusamus et iusto odio dignissimos ducimus', 'Nam libero tempore',
  'Itaque earum rerum hic', 'Et harum quidem', LOCALTIMESTAMP, '3c95eb9c-76db-4b59-8d60-1c11a93c92df', '5bc7f4b0-16f0-445e-b1f7-92684752e5d5')
  INTO APPOINTMENTS (ID, DESCRIPTION, PRECAUTIONS, PRESCRIPTION, REASON, "TIME", DOCTOR_ID, PATIENT_ID)
  VALUES('00edc337-3946-4612-8138-ddf6125ef62a', 'Excepteur sint occaecat cupidatat non proident', 'Facilisi etiam dignissim',
  'Cursus euismod quis viverra nibh', 'Neque porro quisquam', LOCALTIMESTAMP, '1cd4c588-c9b5-4c88-af4f-b89e4544b0cc', '5bc7f4b0-16f0-445e-b1f7-92684752e5d5')
  INTO APPOINTMENTS (ID, DESCRIPTION, PRECAUTIONS, PRESCRIPTION, REASON, "TIME", DOCTOR_ID, PATIENT_ID)
  VALUES('f31c0777-2dc2-4e0d-b844-fe444114fc49', 'Integer feugiat scelerisque varius morbi', 'Turpis cursus in hac',
  'Id semper risus in hendrerit', 'Sagittis aliquam malesuada', LOCALTIMESTAMP, '3c95eb9c-76db-4b59-8d60-1c11a93c92df', '5bc7f4b0-16f0-445e-b1f7-92684752e5d5')
  INTO APPOINTMENTS (ID, DESCRIPTION, PRECAUTIONS, PRESCRIPTION, REASON, "TIME", DOCTOR_ID, PATIENT_ID)
  VALUES('0b2fa6de-4a7e-45ac-9ea0-565bb3481976', 'At vero eos et accusamus et iusto odio', 'Diam sollicitudin tempor',
  'Adipiscing elit duis', 'Et harum quidem', LOCALTIMESTAMP, '1cd4c588-c9b5-4c88-af4f-b89e4544b0cc', '5bc7f4b0-16f0-445e-b1f7-92684752e5d5')
SELECT * FROM dual
WHERE NOT EXISTS (SELECT 1 FROM APPOINTMENTS);

--EXAMS
INSERT ALL
  INTO EXAMS (ID, FILE_URL, LABORATORY, NAME, "RESULT", "TIME", "TYPE", DOCTOR_ID, PATIENT_ID)
  VALUES('4049ddc5-9844-4af9-beae-ecd35ba3c792', 'https://www.4devs.com.br/gerador_de_texto_lorem_ipsum', 'Malesuada',
  'Tristique primis', 'Quam aliquet integer ligula adipiscing quis tellus nibh quisque nec eget euismod', LOCALTIMESTAMP,
  'Convallis', '3c95eb9c-76db-4b59-8d60-1c11a93c92df', '5bc7f4b0-16f0-445e-b1f7-92684752e5d5')
  INTO EXAMS (ID, FILE_URL, LABORATORY, NAME, "RESULT", "TIME", "TYPE", DOCTOR_ID, PATIENT_ID)
  VALUES('9089b5d0-2bc7-493e-b064-46a02afa0e79', 'https://www.4devs.com.br/gerador_de_texto_lorem_ipsum', 'In mattis',
  'At congue porta maecenas', 'Aenean nunc purus imperdiet at non eleifend enim aenean donec', LOCALTIMESTAMP,
  'Condimentum', '1cd4c588-c9b5-4c88-af4f-b89e4544b0cc', '5bc7f4b0-16f0-445e-b1f7-92684752e5d5')
  INTO EXAMS (ID, FILE_URL, LABORATORY, NAME, "RESULT", "TIME", "TYPE", DOCTOR_ID, PATIENT_ID)
  VALUES('af35aa27-177e-44de-8c5d-4dc2233b7d6c', 'https://www.4devs.com.br/gerador_de_texto_lorem_ipsum', 'Suscipit',
  'Eget fringilla', 'Risus sodales mollis eleifend vitae porta aliquam id, tristique orci rutrum quis leo quisque', LOCALTIMESTAMP,
  'Imperdiet', '3c95eb9c-76db-4b59-8d60-1c11a93c92df', '5bc7f4b0-16f0-445e-b1f7-92684752e5d5')
  INTO EXAMS (ID, FILE_URL, LABORATORY, NAME, "RESULT", "TIME", "TYPE", DOCTOR_ID, PATIENT_ID)
  VALUES('7fda53bb-7318-409c-92d6-31c278a23438', 'https://www.4devs.com.br/gerador_de_texto_lorem_ipsum', 'Adipiscing',
  'Netus turpis lacinia', 'Ornare dictum elementum et porttitor et taciti metus a fusce integer', LOCALTIMESTAMP,
  'Orci', '1cd4c588-c9b5-4c88-af4f-b89e4544b0cc', '5bc7f4b0-16f0-445e-b1f7-92684752e5d5')
SELECT * FROM dual
WHERE NOT EXISTS (SELECT 1 FROM EXAMS);