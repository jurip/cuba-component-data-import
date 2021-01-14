import { StandardEntity } from "./base/sys$StandardEntity";
export class Operation extends StandardEntity {
  static NAME = "ddcdi_Operation";
  purposeOfPayment?: string | null;
  income?: string | null;
  outcome?: string | null;
  counterAgentAccountNumber?: string | null;
  counterAgentBankName?: string | null;
  counterAgentBankCorrAccount?: string | null;
  counterAgentBankBIK?: string | null;
  counterAgentINN?: string | null;
  counterAgent?: string | null;
  accountNumber?: string | null;
  date?: any | null;
  docNumber?: string | null;
}
export type OperationViewName = "_base" | "_local" | "_minimal";
export type OperationView<V extends OperationViewName> = V extends "_base"
  ? Pick<
      Operation,
      | "id"
      | "purposeOfPayment"
      | "income"
      | "outcome"
      | "counterAgentAccountNumber"
      | "counterAgentBankName"
      | "counterAgentBankCorrAccount"
      | "counterAgentBankBIK"
      | "counterAgentINN"
      | "counterAgent"
      | "accountNumber"
      | "date"
      | "docNumber"
    >
  : V extends "_local"
  ? Pick<
      Operation,
      | "id"
      | "purposeOfPayment"
      | "income"
      | "outcome"
      | "counterAgentAccountNumber"
      | "counterAgentBankName"
      | "counterAgentBankCorrAccount"
      | "counterAgentBankBIK"
      | "counterAgentINN"
      | "counterAgent"
      | "accountNumber"
      | "date"
      | "docNumber"
    >
  : never;
