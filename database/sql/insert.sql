INSERT INTO public.asset_category  (id, description, "name") VALUES('1', 'Crypto', 'Crypto');
INSERT INTO public.asset_category (id, description, "name") VALUES('2', 'Stock', 'Stock');
INSERT INTO public.asset_category (id, description, "name") VALUES('3', 'Bond', 'Bond');
--
INSERT INTO public.asset (id, code, created_date, "name", updated_date, asset_category_id) VALUES('1', 'BTC', NULL, 'Bitcoin', NULL, '1');
INSERT INTO public.asset (id, code, created_date, "name", updated_date, asset_category_id) VALUES('2', 'DOGE', NULL, 'Dogecoin', NULL, '1');
INSERT INTO public.asset (id, code, created_date, "name", updated_date, asset_category_id) VALUES('3', 'ADA', NULL, 'Cardano', NULL, '1');
INSERT INTO public.asset (id, code, created_date, "name", updated_date, asset_category_id) VALUES('4', 'ETH', NULL, 'Ethereum', NULL, '1');
INSERT INTO public.asset (id, code, created_date, "name", updated_date, asset_category_id) VALUES('5', 'BNB', NULL, 'Binance Coin', NULL, '1');
INSERT INTO public.asset (id, code, created_date, "name", updated_date, asset_category_id) VALUES('6', 'SOL', NULL, 'Solana', NULL, '1');
INSERT INTO public.asset (id, code, created_date, "name", updated_date, asset_category_id) VALUES('7', 'DOT', NULL, 'Polkadot', NULL, '1');

--
INSERT INTO public.asset_holding (id, "hold", asset_id) VALUES('1', 1.0, '1');
--
INSERT INTO public.asset_transaction (id, created_date, notes, price, updated_date, asset_holding_id) VALUES('1', NULL, 'BTC', 48000.0, NULL, '1');




